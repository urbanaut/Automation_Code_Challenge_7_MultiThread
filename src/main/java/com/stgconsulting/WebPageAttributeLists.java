package com.stgconsulting;

import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Richard Harkins on 10/14/2016.
 */
public class WebPageAttributeLists extends SeleniumWebdriverBaseClass implements Callable
{
    private String url;
    List<String> hrefAttributeValues = new ArrayList<String>();
    List<WebsiteWordsRecord> webpageWordsList = new ArrayList<WebsiteWordsRecord>();

    public WebPageAttributeLists(String url) throws IOException
    {
        this.url = url;
    }

    public String getURL()
    {
        return this.url;
    }

//    public List<String> getHrefAttributeValues()
//    {
//        return this.hrefAttributeValues;
//    }
//
//    public String[] getAllTextOnPage()
//    {
//        return this.stringArray;
//    }
//
//    public void setHrefAtributeValues(List<String> inputHrefAttributeValues)
//    {
//        this.hrefAttributeValues = inputHrefAttributeValues;
//    }
//
//    public void setAllTextonPage(String inputAllTextonPage)
//    {
//        this.allTextOnPage = inputAllTextonPage;
//    }
//
    public List<String> call()throws StaleElementReferenceException, InterruptedException
    {
        driver.navigate().to(url);

//        WebDriver driver = new HtmlUnitDriver();
        WebElement htmlElement = null;
//        WebElement htmlElement = driver.findElement(By.xpath("/html"));
////    WebElement htmlElement = driver.findElement(By.tagName("html"));
        String allTextOnPage = null;
        List<WebElement> anchorTags = null;
//
////    String newLinesRemoved = allTextOnPage.replaceAll("[\\s]+|[\\n]+|[\\u25BC]+|[\\&]+|:|\\\\|\\.|,|\\?|©|®|[(]+|[)]+", " ");
//        String newLinesRemoved = allTextOnPage.replaceAll("[^A-Za-z]+", " ");
//        String spaceDelimiterToOne = newLinesRemoved.replaceAll("\\s+", " ");
//        String[] stringArray = spaceDelimiterToOne.split("[\\s]");
//        String[] newWords = stringArray;

//
        anchorTags = driver.findElements(By.xpath(".//a[@href[starts-with(.,'https://www.skiutah.com') and not(contains(., '@@')) and not(contains(., '?'))]]"));
//        anchorTags = driver.findElements(By.xpath(".//a[@href[starts-with(.,'https://www.skiutah.com') and not(contains(., '@@')) and not(contains(., 'blog')) and not(contains(., '?'))]]"));

        try
        {
//            driver.navigate().refresh();
        htmlElement = driver.findElement(By.xpath("/html"));
//        allTextOnPage = htmlElement.getText();

            for (WebElement anchorTagElement : anchorTags)
            {
                hrefAttributeValues.add(anchorTagElement.getAttribute("href"));
//                // Webpage words processing - begin
//                    for (String arrayValue : newWords)
//                    {
//                        WebsiteWordsRecord initialWordsRecord = new WebsiteWordsRecord();
//                        initialWordsRecord.setWord(arrayValue);
//                        initialWordsRecord.setWebsite(driver.getCurrentUrl());
//                        initialWordsRecord.setOccurrences(1);
//                        if (webpageWordsList.contains(initialWordsRecord))
//                        {
//                            int initialWordsrecordIndex = webpageWordsList.indexOf(initialWordsRecord);
//                            WebsiteWordsRecord updateRecord = new WebsiteWordsRecord();
//                            updateRecord = webpageWordsList.get(initialWordsrecordIndex);
//                            updateRecord.setOccurrences(updateRecord.getOccurrences()+1);
//            //                webpageWordsList.add(initialWordsrecordIndex, updateRecord);
//                        }
//                        else
//                        {
//                            webpageWordsList.add(initialWordsRecord);
//                        }
//            //            initialWordsRecord.setWord(null);
//            //            initialWordsRecord.setWebsite(null);
//            //            initialWordsRecord.setOccurrences(0);
//                    }
//                    // Webpage word processing - end


            }

//            return hrefAttributeValues;

        }

        catch(StaleElementReferenceException e)
        {

        }

        catch(NullPointerException e)
        {

        }

        catch(NoSuchElementException e)
        {

        }

//        return hrefAttributeValues;

//        this.setHrefAtributeValues(hrefAttributeValues);
//        this.hrefAttributeValues = inputHrefAttributeValues;
//        this.setAllTextonPage(allTextOnPage);
        return hrefAttributeValues;
//        return this;
    }

}
