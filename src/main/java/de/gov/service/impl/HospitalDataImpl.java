package de.gov.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.gov.dao.AnnualQuarterDAO;
import de.gov.dao.AreaDAO;
import de.gov.dao.DataPCTIndexDAO;
import de.gov.dao.HospitalDataImplDAO;
import de.gov.dto.HospitalAllDTO;
import de.gov.entity.AnnualQuarter;
import de.gov.entity.DataPCTIndex;
import de.gov.entity.HospitalData;
import de.gov.service.IHospitalDataImpl;
import de.gov.vo.AnnualQuarterVO;
import de.gov.vo.HospitalAllVO;

/**
 * 慢性病開立慢性病連續處方簽百分比
 *
 * @author Joyce
 * @version 0.0.1
 */
@Service
@Transactional
public class HospitalDataImpl implements IHospitalDataImpl {

	@Autowired
	HospitalDataImplDAO hospitalDataImplDAO;

	@Autowired
	DataPCTIndexDAO dataPCTIndexDAO;

	@Autowired
	AreaDAO areaDAO;

	@Autowired
	AnnualQuarterDAO annualQuarterDAO;


	private int fileCount ;
	// 定位需要掃描的資料夾
	private static final File folder = new File("C:\\JavaDataTest");
	String strFolder = "C:\\JavaDataTest\\";
	Logger logger = LogManager.getLogger(HospitalDataImpl.class);

	@Override
	public void insert() {
		
		// 掃描Folder並檢查是否掃描過,若未掃描則insert進DB
		scanFolderAndInsertDB();
		
	}
	
	
	
	
//	---------------------------------------------------------

	public void scanFolderAndInsertDB() {
		String str = folderCount();
		if(fileCount <= 0) {
			return;
		}
			try {
				List<HospitalAllDTO> list = read(str);
				//遍歷我收到的所有List資料
				for (HospitalAllDTO hospitalAllDTO : list) {
					List<HospitalAllVO> hospitalNames = hospitalDataImplDAO
							.selectHospitalName(hospitalAllDTO.getHospitalName(), hospitalAllDTO.getCountyCity());

					DataPCTIndex dataPCTIndex = new DataPCTIndex();
					BeanUtils.copyProperties(hospitalAllDTO, dataPCTIndex);

					Long hospitalId;
					if (hospitalNames.isEmpty()) {
						// 查出地址對應的id並賦值
						int areaId = areaDAO.selectByAreaNameGetId(hospitalAllDTO.getCountyCity());
						hospitalAllDTO.setAreaId(areaId);
						//logger.error(hospitalAllDTO.getAppointedId());
						// 判斷若插入的特約類別等於0代表異常,異常部分寫進log做紀錄。
						if (hospitalAllDTO.getAppointedId() == 0) {
							logger.error("This Appointed Name is Exception!" + hospitalAllDTO.getHospitalName());
						}

						// 將DTO給到entity。
						HospitalData hospitalData = new HospitalData();
						BeanUtils.copyProperties(hospitalAllDTO, hospitalData);
						// 將處理好的data insert進DB
						int row = hospitalDataImplDAO.insert(hospitalData);
						hospitalId = hospitalData.getId();
						dataPCTIndex.setHospitalId(hospitalId);

					} else {
						// 若List內有數據則代表資料庫已存在相同資料，則進到else並跳過之後操作
						for (HospitalAllVO hospitalName : hospitalNames) {
							//logger.error("hospitalName=" + hospitalName.getId());
							hospitalId = hospitalName.getId();
							dataPCTIndex.setHospitalId(hospitalId);
						}
					}

					dataPCTIndexInsert(dataPCTIndex);
					File file = new File(str);
					file.delete();
					fileCount = fileCount--;
					
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("死掉啦");
			}
		
			if(fileCount >= 1) {
				insert();
			}
	}

	public void dataPCTIndexInsert(DataPCTIndex dataPCTIndex) {
		dataPCTIndexDAO.insert(dataPCTIndex);
	}

	public String folderCount() {
		// 該資料夾中總共有多少檔案
		fileCount=0;
		List<String> list = new ArrayList<>();
		try {
			for (File file : folder.listFiles()) {
				if (!file.isDirectory()) {
					logger.error("file=" + file.getName());
					fileCount++;
					
					String str = strFolder + file.getName();
					
					return str;
				}
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public List<HospitalAllDTO> read(String path) throws Exception {

		// 最后输出的实体类的集合
		List<HospitalAllDTO> arr = new ArrayList();
		
		// 1. 创建输入流
		FileInputStream fip = new FileInputStream(path);
		// 2. 在输入流中获取工作簿（excel表格）
		XSSFWorkbook workbook = new XSSFWorkbook(fip);
		// 3. 在目标工作簿中获取目标工作表 0:表示第一个工作表
		Sheet sheet = workbook.getSheetAt(0);
		// 4. 获取工作表的行数（有数据的）
		int rowNum = sheet.getPhysicalNumberOfRows();
		// 除去第一行，有效数据从第二行开始
		//偷87
		for (int i = 1; i < rowNum; i++) {
//			logger.error("我是第 "+i+" 筆資料");
			// 5. 获取除第一行以外的所有行
			Row row = sheet.getRow(i);
			if (row != null) {
				// 用于保存每一行数据的集合
				List<String> list = new ArrayList<>();
				for (Cell cell : row) {
//					logger.error("我是cell:"+cell);
					if (cell != null) {
						// 6. 把一行中所有的数据转化为String，方便数据处理
						cell.setCellType(Cell.CELL_TYPE_STRING);
						// 7. 获取所有单元格的数据
						//logger.error("轉換字串開始");
						String value = cell.getStringCellValue();
//						logger.error("我是value:"+value);
						//logger.error("轉換字串結束");
						if (value != null && !value.equals("")) {
							// 8. 将每一个单元格的数据放入到list集合中
							
//							if(value.equals("NULL")) {
//
//								value = null;
//							}
							list.add(value);
						}
					}
						
				}
				// 9. 把获取的每一行数据封装成HospitalData对象
				if (list.size() > 0) {
					/*
					 * list.get(8) and list.get(9)調用年度季度進Entity
					 * 之後會與其他欄位置做整理一起塞進DTO
					 */
					AnnualQuarter annualQuarter = new AnnualQuarter(
							Integer.parseInt(list.get(8)), list.get(9));
					
					List<AnnualQuarterVO> selectAnnualQuarters = annualQuarterDAO.select(annualQuarter);
//------------------------------------------------------------------------------------------------------
					/* list.get(0)是第一欄(A欄：醫事機構名稱),//list.get(1)是第二欄(B欄：縣市別)...以此類推
					 * 
					 * Integer.parseInt(list.get(2))是因為179列的程式：List<String> list = new ArrayList<>();
					 * 原本泛型規定是String且資料庫也是INT型別，所以將其轉換型別為INT...以此類推
					 * 
					 * list.get(5)欄為名：院所指標值 因可以透過現有資料(分子/分母)計算得出，所以不寫入資料庫。
					 */
					Integer cell_numerator = null , cell_denominator = null;
					try {
						cell_numerator=Integer.parseInt(list.get(3));
						
					} catch (Exception e) {
						cell_numerator=null;
					}
					try {
						cell_denominator=Integer.parseInt(list.get(4));
						
					} catch (Exception e) {
						cell_denominator=null;
					}

					
					HospitalAllDTO hospitalDataDTO = new HospitalAllDTO(list.get(0), list.get(1),
							Integer.parseInt(list.get(2)), cell_numerator, cell_denominator,
							Double.parseDouble(list.get(6)), Double.parseDouble(list.get(7)),Integer.parseInt(list.get(10)));
					
					/*
					 * 如果List為空，則插入年度季度，並取得主key
					 * 如果不為空，取得年度季度的主key，將主Key給到DTO，將DTO的Foreign key做關聯
					 */
					
					if (selectAnnualQuarters.isEmpty()) {
						
						annualQuarterDAO.insert(annualQuarter);
	
						hospitalDataDTO.setAnnualQuarterId(annualQuarter.getId());
					}else {
						
						for (AnnualQuarterVO selectAnnualQuarter : selectAnnualQuarters) {
							hospitalDataDTO.setAnnualQuarterId(selectAnnualQuarter.getId());

						}
					}
					
					arr.add(hospitalDataDTO);

				}
			}
		}
		return arr;
	}

}
