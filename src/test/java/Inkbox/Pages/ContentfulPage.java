package Inkbox.Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;

public class ContentfulPage {
	ExtentTest test;

	public ContentfulPage(ExtentTest test) {

		this.test = test;
		ControlHelpers controlHelpers = new ControlHelpers(test);
	}

	String Login_link = "//div[text()='Log in']";
	String EmailId = "//input[@id='user_email']";
	String Password = "//input[@id='user_password']";
	String Login_button = "//input[@value='Log in' and @type='submit']";

	// shop by section
	String ShopBySection = "//div/h1[text()='Shop by Section']";
	String ShopByProduct = "//div/h1[contains(text(),'Shop by Product')]";

	public void Contentful_Login() {
		// ControlHelpers.ButtonClick(By.xpath(Login_link));
		ControlHelpers.Entertext(By.xpath(EmailId), "inkboxqa@getinkbox.com");
		ControlHelpers.Entertext(By.xpath(Password), "Pa55word123!!!");
		ControlHelpers.ButtonClick(By.xpath(Login_button));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Hero_Banner_validation() {
//fromContentFul
		ControlHelpers.GetDriver().get("https://app.contentful.com/spaces/pkpedwjf5oyt/entries/qNZptxr5VNANDVrNUdmiM");
		ControlHelpers.ButtonClick(By.xpath("//div/h1[text()='NTW - Homepage Sale Hero Banner']"));
		// toget Title
		String TitleContentful = ControlHelpers.getText(
				By.xpath("(//div/label[text()='Title'])[2]/parent::div/following-sibling::div/descendant::input"));

		String descriptionContentful = ControlHelpers
				.getText(By.xpath("//div[@class='CodeMirror-lines']/descendant::span[@role='presentation']"));

		String buttonContentful = ControlHelpers
				.getText(By.xpath("//label[text()='Button']/parent::div/following-sibling::div/descendant::h1"));

		ControlHelpers.GetDriver().get("https://inkbox.com/");

		String TitleInbox = ControlHelpers
				.getText(By.xpath("//section[contains(@id,'promo_banner_separate')]/descendant::h1"));
		String descriptionInkbox = ControlHelpers.getText(
				By.xpath("//section[contains(@id,'promo_banner_separate')]/descendant::div[@class='items-center']/p"));

		String button_inbox = ControlHelpers
				.getText(By.xpath("//div[contains(@id,'button')]/a[text()='Meet Our Artists']"));

		if (TitleContentful.contains(TitleInbox)) {
			test.log(LogStatus.PASS, "Title Validation of Hero Banner is scccess");
		} else {
			test.log(LogStatus.ERROR, "Title in contentful  site is :" + TitleContentful
					+ " is differ from title in Inkbox :" + TitleInbox);
		}

		if (descriptionContentful.contains(descriptionInkbox)) {
			test.log(LogStatus.PASS, "Description  Validation of Hero Banner is scccess");
		} else {
			test.log(LogStatus.ERROR, "Description in contentful  site is :" + descriptionContentful
					+ " is differ from Description in Inkbox :" + descriptionInkbox);
		}

		if (buttonContentful.contains(button_inbox)) {
			test.log(LogStatus.PASS, "Meet Our Artists button  Validation of Hero Banner is scccess");
		} else {
			test.log(LogStatus.ERROR, "Button in contentful  site is :" + buttonContentful
					+ " is differ from Button in Inkbox :" + button_inbox);
		}
	}

	public void ShopBySection_Validation() {
		try {

			// Getting data from Contentful page and store it under
			// Hasmap(shopByselection_Map)
			ControlHelpers.GetDriver()
					.get("https://app.contentful.com/spaces/pkpedwjf5oyt/entries/qNZptxr5VNANDVrNUdmiM");
			ControlHelpers.ButtonClick(By.xpath(ShopBySection));
			HashMap<String, List<String>> shopByselection_Map = new HashMap<String, List<String>>();
			List<WebElement> ShopByselection_List = ControlHelpers.getElementsList(
					By.xpath("//label[text()='List Items']/parent::div/following-sibling::div/descendant::h1"));
			int i = 0;
			for (WebElement webElement : ShopByselection_List) {
				i = i + 1;
				List<String> Ele_List = new ArrayList<String>();
				String xpath1 = "(//label[text()='List Items']/parent::div/following-sibling::div/descendant::h1)[" + i
						+ "]";

				String keyValue = ControlHelpers.getText(By.xpath(xpath1));
				ControlHelpers.MoveToElementAndClick(By.xpath(xpath1));
				Ele_List.add(ControlHelpers
						.getText(By.xpath("//div[@role='presentation']/div/pre/span[@role='presentation']")));

				ControlHelpers.GetDriver().switchTo()
						.frame(ControlHelpers.GetDriver().findElement(By.xpath("//iframe[@title='widget-renderer']")));
				String Img_src = ControlHelpers.getAttribute(By.xpath("(//div[@id='root']/descendant::img)[1]"), "src");
				Img_src = Img_src.replace("https:", "").replace(" ", "");
				https: Ele_List
						.add(ControlHelpers.getAttribute(By.xpath("(//div[@id='root']/descendant::img)[1]"), "src"));

				Thread.sleep(2000);

				ControlHelpers.GetDriver().switchTo().defaultContent();

				Thread.sleep(2000);

				shopByselection_Map.put(keyValue, Ele_List);

				Thread.sleep(4000);

				ControlHelpers.ButtonClick(By.xpath(
						"/html/body/div[2]/cf-app-container/div[2]/react-component/div/div[3]/div/div/div[1]/div[1]/button/span"));

				Thread.sleep(2000);

			}

			// Getting data from inkbox.com and store it under
			// Hasmap(shopByselection_Inkbox_Map)
			ControlHelpers.GetDriver().get("https://inkbox.com/");
			Thread.sleep(4000);
			Ads ads = new Ads(test);
			ads.closeAd();
			HashMap<String, List<String>> shopByselection_Inkbox_Map = new HashMap<String, List<String>>();
			List<WebElement> ShopByselection_List_inbox = ControlHelpers.getElementsList(By.xpath(
					"(//div/h1[contains(text(),'Shop by Section')]/parent::div/following-sibling::div)[2]/descendant::div[@class='trayItem']"));
			int k = 0;
			for (WebElement webElement : ShopByselection_List_inbox) {
				k = k + 1;
				List<String> Ele_List = new ArrayList<String>();
				String title = ControlHelpers.getText(By.xpath(
						"((//div/h1[contains(text(),'Shop by Section')]/parent::div/following-sibling::div)[2]/descendant::div[@class='trayItem'])["
								+ k + "]//p[contains(@class,'title')]"));
				Ele_List.add(ControlHelpers.getText(By.xpath(
						"((//div/h1[contains(text(),'Shop by Section')]/parent::div/following-sibling::div)[2]/descendant::div[@class='trayItem'])["
								+ k + "]//p[contains(@class,'description')]")));
				String Img_src = ControlHelpers.getAttribute(By.xpath(
						"((//div/h1[contains(text(),'Shop by Section')]/parent::div/following-sibling::div)[2]/descendant::div[@class='trayItem'])["
								+ k + "]//img"),
						"srcset");
				Img_src = Img_src.replace("https:", "").replace(" ", "").replace("%20", "");
				Ele_List.add(Img_src);
				// Ele_List.add(ControlHelpers.getAttribute(By.xpath("(//div[@id='root']/descendant::img)[1]"),
				// "src"));
				shopByselection_Inkbox_Map.put(title, Ele_List);
			}

			// Validating data undershopByselection with contentFul

			for (Entry<String, List<String>> data_content : shopByselection_Map.entrySet()) {
				for (Entry<String, List<String>> data_inkbox : shopByselection_Inkbox_Map.entrySet()) {
					if (data_content.getKey().equalsIgnoreCase(data_inkbox.getKey())) {
						List<String> value_content = data_content.getValue();
						List<String> value_inkbox = data_inkbox.getValue();

						for (int j = 0; j < value_content.size(); j++) {

							String value = value_content.get(j);
							value = value.replace("https:", "").replace(" ", "").replace("%20", "");

							String value2 = value_inkbox.get(j);
							value2 = value2.replace("https:", "").replace(" ", "").replace("%20", "");
							if (value2.contains(value)) {
								test.log(LogStatus.PASS,
										"Validate success for :" + value + " -under :" + data_content.getKey());
							} else {
								test.log(LogStatus.FAIL,
										"Validate fail for :" + value + " -under :" + data_content.getKey());
							}

						}

					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public void ShopByProduct_Validation() {
		try
		{
			ControlHelpers.GetDriver().get("https://app.contentful.com/spaces/pkpedwjf5oyt/entries/qNZptxr5VNANDVrNUdmiM");
			ControlHelpers.ButtonClick(By.xpath(ShopByProduct));
			HashMap<String, List<String>> ShopByProduct_Map = new HashMap<String, List<String>>();
			List<WebElement> ShopByProduct_List = ControlHelpers.getElementsList(
					By.xpath("//label[text()='List Items']/parent::div/following-sibling::div/descendant::h1"));
			int i = 0;
			for (WebElement webElement : ShopByProduct_List) {
				i = i + 1;
				List<String> Ele_List = new ArrayList<String>();
				String xpath1 = "(//label[text()='List Items']/parent::div/following-sibling::div/descendant::h1)[" + i
						+ "]";

				String keyValue = ControlHelpers.getText(By.xpath(xpath1));
				ControlHelpers.MoveToElementAndClick(By.xpath(xpath1));
				Ele_List.add(ControlHelpers
						.getText(By.xpath("//div[@role='presentation']/div/pre/span[@role='presentation']")));

				ControlHelpers.GetDriver().switchTo()
						.frame(ControlHelpers.GetDriver().findElement(By.xpath("//iframe[@title='widget-renderer']")));
				String Img_src = ControlHelpers.getAttribute(By.xpath("(//div[@id='root']/descendant::img)[1]"), "src");
				Img_src = Img_src.replace("https:", "").replace(" ", "");
				https: Ele_List
						.add(ControlHelpers.getAttribute(By.xpath("(//div[@id='root']/descendant::img)[1]"), "src"));

				Thread.sleep(2000);

				ControlHelpers.GetDriver().switchTo().defaultContent();

				Thread.sleep(2000);

				ShopByProduct_Map.put(keyValue, Ele_List);

				Thread.sleep(4000);

				ControlHelpers.ButtonClick(By.xpath(
						"/html/body/div[2]/cf-app-container/div[2]/react-component/div/div[3]/div/div/div[1]/div[1]/button/span"));

				Thread.sleep(2000);

			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		
	}

}
