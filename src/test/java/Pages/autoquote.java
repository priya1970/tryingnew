package Pages;



	import org.openqa.selenium.firefox.FirefoxDriver;
	//import java.util.concurrent.TimeUnit;
	import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.io.*;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.*;
	import org.openqa.selenium.support.ui.Select;


	public class autoquote {
		
		public static WebDriver driver=new FirefoxDriver();
		public static String url = "http://demo.borland.com/InsuranceWebExtJS/index.jsf";
		
		
		@BeforeTest
		public void openapplication1() throws InterruptedException
		{
			
			driver.get(url);
			Thread.sleep(3000);
			
		}
			

		 public static void main (String[] args) throws InterruptedException, IOException
		  {
		  
		     WebDriver driver=new FirefoxDriver();
		     driver.get(url);
			 String actualOutput;
			 String src="E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\ApplicationTestData\\autquote.xlsx";
			
			   String sheetName="Sheet2";
			   File file =    new File(src);
		           FileInputStream inputStream = new FileInputStream(file);
		           Workbook  wb = new XSSFWorkbook(inputStream);
		
			   Sheet sht = wb.getSheet(sheetName);
			   int rowCount = sht.getLastRowNum()-sht.getFirstRowNum();
			   System.out.println("Row count:" + rowCount);

			   driver.manage().window().maximize();
			
			   driver.get(url);
			 	  
			   for (int i = 1; i < rowCount; i++) {
						  
				  Row row = sht.getRow(i);
				      
						   
				  Select autoquote = new Select(driver.findElement(By.id("quick-link:jump-menu")));
				  autoquote.selectByVisibleText("Auto Quote");
							 
				  String titlePage = driver.getTitle();
				  System.out.println("Auto Quote Page Title:"+titlePage);
						
				  driver.findElement(By.id("autoquote:zipcode")).clear();
				  driver.findElement(By.id("autoquote:zipcode")).sendKeys(row.getCell(0).toString());
				  driver.findElement(By.id("autoquote:e-mail")).clear();
			          driver.findElement(By.id("autoquote:e-mail")).sendKeys(row.getCell(1).getStringCellValue());
					    
			         
					    
				// AUTOMOBILE TYPE RADIO BUTTON
			           String value= row.getCell(2).toString();
			           String value1= "Car";
				   if(value.equals(value1))
				     {
				      driver.findElement(By.id("autoquote:vehicle:0")).click();
				      Thread.sleep(1000);
				     }
			           else
			             { 
				      driver.findElement(By.id("autoquote:vehicle:1")).click();
				      Thread.sleep(1000);
				     }
		
				      driver.findElement(By.id("autoquote:next")).click();
			              Thread.sleep(1000);
							 
				      driver.findElement(By.id("autoquote:age")).clear();
				      Thread.sleep(500);
						
				      driver.findElement(By.id("autoquote:age")).sendKeys(row.getCell(3).toString());
						
				     //Gender RADIO BUTTON
				    String gender= row.getCell(4).toString();
			            String gender1= "Male";
				    if(gender.equals(gender1))
				    {
				      driver.findElement(By.id("autoquote:gender:0")).click();
				      Thread.sleep(1000);
				    }
				    else
				     { 
				       driver.findElement(By.id("autoquote:gender:1")).click();
				       Thread.sleep(1000);
				     }
						
				 //Driving Record
				    String record= row.getCell(5).toString();
			            String record1= "Excellent";
			            String record2= "Good";
			            String record3= "Fair";
			            if(record.equals(record1))
			             {
					 driver.findElement(By.id("autoquote:type:0")).click();
					 Thread.sleep(1000);
				     }
				   else if(record.equals(record2))
				    { 
					 driver.findElement(By.id("autoquote:type:1")).click();
					 Thread.sleep(1000);
				    }
				   else if(record.equals(record3))
				    { 
					 driver.findElement(By.id("autoquote:type:2")).click();
					 Thread.sleep(1000);
				    }
				   else
				    {
	                                 driver.findElement(By.id("autoquote:type:3")).click();
					 Thread.sleep(1000);
			            }
					     
				        driver.findElement(By.id("autoquote:next")).click();
				        Thread.sleep(1000);
					
				//YEAR
				 driver.findElement(By.id("autoquote:year")).clear();
				 driver.findElement(By.id("autoquote:year")).sendKeys(row.getCell(6).getStringCellValue());
							 
			       //MAKE COMBO BOX
						
				driver.findElement(By.xpath(".//*[@id='ext-gen4']")).click();
				Thread.sleep(1000);
						
				//Reading content from combo box
				String makecombo=driver.findElement(By.xpath(".//*[@id='ext-gen8']")).getText(); 
				
					 	
				//split the content
				String splt1[] = makecombo.split("\n"); 
				System.out.println("array length of make Is -> "+splt1.length);
					 	
				//Reading content from excel
			        String make= row.getCell(7).toString();
						
				int m;
				for(m=0;m<splt1.length;m++)
				{
				     System.out.println(make.equals(splt1[m]));
				     System.out.println(m);
				      if(make.equals(splt1[m]))
				       {
					 if(m==0)
					  driver.findElement(By.xpath(".//*[@id='ext-gen8']/div[1]")).click();
					else if(m==1)
					  driver.findElement(By.xpath(".//*[@id='ext-gen8']/div[2]")).click();
					else if(m==2)
					  driver.findElement(By.xpath(".//*[@id='ext-gen8']/div[3]")).click();
					else if(m==3)
					  driver.findElement(By.xpath(".//*[@id='ext-gen8']/div[4]")).click();
					else if(m==4)
					 driver.findElement(By.xpath(".//*[@id='ext-gen8']/div[5]")).click();
					else if(m==5)
					 driver.findElement(By.xpath(".//*[@id='ext-gen8']/div[6]")).click();
					 m=splt1.length;
					}
				}
						
						
				//MODEL

				driver.findElement(By.xpath(".//*[@id='ext-gen6']")).click();
				Thread.sleep(1000);
						
	              
				String modelcombo=driver.findElement(By.xpath(".//*[@id='ext-gen12']")).getText();
					 	 
		                String splt[] = modelcombo.split("\n"); 

					 	
				System.out.println("array length OF Model Is -> "+splt.length); 
				String model= row.getCell(8).toString();
				int a;
				for(a=0;a<splt.length;a++)
				{
				  System.out.println(model.equals(splt[a]));
				  System.out.println(a);
				  if(model.equals(splt[a]))
				   {
					if(a==0)
					driver.findElement(By.xpath(".//*[@id='ext-gen12']/div[1]")).click();
					else if(a==1)
					driver.findElement(By.xpath(".//*[@id='ext-gen12']/div[2]")).click();
					else if(a==2)
					driver.findElement(By.xpath(".//*[@id='ext-gen12']/div[3]")).click();
					else if(a==3)
				        driver.findElement(By.xpath(".//*[@id='ext-gen12']/div[4]")).click();
				        else if(a==4)
					driver.findElement(By.xpath(".//*[@id='ext-gen12']/div[5]")).click();
					else if(a==5)
					driver.findElement(By.xpath(".//*[@id='ext-gen12']/div[6]")).click();
					else if(a==6)
					driver.findElement(By.xpath(".//*[@id='ext-gen12']/div[7]")).click();
				        a=splt.length;
				    }
							
				}
					 	  
				Thread.sleep(1000);
						
				//FINANCIAL INFO
				String finance= row.getCell(9).toString();
			        String finance1= "Own";
			        String finance2= "Financed";
			            
			        if(finance.equals(finance1))
				{
			           driver.findElement(By.id("autoquote:finInfo:0")).click();
			           Thread.sleep(1000);
			        }
				else if(finance.equals(finance2))
			        { 
			           driver.findElement(By.id("autoquote:finInfo:1")).click();
				   Thread.sleep(1000);
			        }
		                else
			        {
				   driver.findElement(By.id("autoquote:finInfo:2")).click();
			           Thread.sleep(1000);
			        }
			
			       driver.findElement(By.id("autoquote:next")).click();
			       Thread.sleep(1000);
					 	
			      //CLICK ON HOME LINK 
			       driver.findElement(By.id("home")).click();
			       Thread.sleep(1500);
				  
		            }
				    
				   wb.close();
			       inputStream.close(); 
			      
			 	   driver.close();
			 	   driver.quit();
		  
						   
		       }
		  }
	

