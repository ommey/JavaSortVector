import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        XSSFCell Col = null;
        XSSFRow Row = null;
		try
		{
		File Golden = new File("C:\\Data\\Golden.xlsx");
		FileInputStream fis1 = new FileInputStream(Golden);
		File Current = new File("C:\\Data\\Current.xlsx");
		Vector<String> VGolden= new Vector<>();
		Vector<String> VCurrent= new Vector<>();
		Vector<String> VTemp = new Vector<>();
		FileInputStream fis2 = new FileInputStream(Current);	
		XSSFWorkbook Gwb = new XSSFWorkbook(fis1);
		XSSFWorkbook Cwb = new XSSFWorkbook(fis2);
		XSSFSheet Gsheet1 = Gwb.getSheetAt(0);
		XSSFSheet Csheet1 = Cwb.getSheetAt(0);
		int Gcolcount = Gsheet1.getRow(0).getLastCellNum();  // Global File Column Count
		int Ccolcount = Csheet1.getRow(0).getLastCellNum();  // Current File Column Count
		System.out.println("Global Column Count ::" + Gcolcount);
		System.out.println("Current Column Count ::" + Ccolcount);
		String Data = Gsheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data :" + Data);
		for( int i =0; i< Gcolcount; i++)
		{
			String GoldenData = Gsheet1.getRow(0).getCell(i).getStringCellValue();
			System.out.println("Global Col Index :: " + GoldenData);
			VGolden.add(GoldenData);
		}
		Iterator<String> Gitr = VGolden.iterator();
		while(Gitr.hasNext())
		{
			System.out.println(Gitr.next());
		}
		
		for( int j =0; j< Ccolcount; j++)
		{
			String CurrentData = Csheet1.getRow(0).getCell(j).getStringCellValue();
			System.out.println("Current Col Index :: " + CurrentData);
			VCurrent.add(CurrentData);
		}
		Iterator<String> Citr = VCurrent.iterator();
		while(Citr.hasNext())
		{
			System.out.println(Citr.next());
		}
		for (int i=0; i<Gcolcount;i++)
		{
			//int j=0;
			i = i+1;
			
			for(int j=0; j<Ccolcount;j++)
			{
			if(VGolden.get(i) == VCurrent.get(j))
			{
				String GTemp = VGolden.get(i);
				System.out.println("Temp Vector :: " + GTemp);
				VTemp.add(GTemp);
			}
			/*else
			{
				String CTemp = VCurrent.get(j);
				System.out.println("TempC Vector :: " + CTemp);
				VTemp.add(CTemp);
			}
			*/
			}
				
		}
		/*while(Gitr.hasNext())
		{
			int i =0;
			if(VGolden.listIterator(i).equals(VCurrent.listIterator(j)))
			{}
		}*/
		Gwb.close();
		Cwb.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
	}

}
     