package com.stgconsulting;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Richard Harkins on 8/22/2016.
 */
public class WebPageCrawler extends SeleniumWebdriverBaseClass implements Callable
{

    private String url;

    public WebPageCrawler(String url) throws IOException
    {
        this.url = url;
    }

    public List<String> call() throws StaleElementReferenceException, InterruptedException {
//        LocalDateTime crawlerStartTime = LocalDateTime.now();
        List<WebElement> anchorTags = null;
        List<String> hrefAttributeValues = new ArrayList<String>();
//        List<String> pagesToVisit = new ArrayList<String>();
//        List<String> pagesVisited = new ArrayList<String>();
//        String currentPageURL = baseWebPageURL;
//        pagesVisited.add(baseWebPageURL);
//        System.out.println("WebCrawler Start Time - " + crawlerStartTime);
//        System.out.println("pagesVisited size = " + pagesVisited.size());
//        System.out.println("pagesVisited website = " + pagesVisited.get(pagesVisited.size()-1));

//        anchorTags.clear();
//        hrefAttributeValues.clear();

        driver.navigate().to(url);

        anchorTags = driver.findElements(By.xpath(".//a[@href[starts-with(.,'https://www.skiutah.com') and not(contains(., '@@')) and not(contains(., '?'))]]"));
//        anchorTags = driver.findElements(By.xpath(".//a[@href[starts-with(.,'https://www.skiutah.com') and not(contains(., '@@')) and not(contains(., 'blog')) and not(contains(., '?'))]]"));
//        anchorTags = driver.findElements(By.xpath(".//a[@href[starts-with(.,'https://www.skiutah.com') or starts-with(.,'/')]]"));
//        anchorTags = driver.findElements(By.xpath(".//a[@href[starts-with(.,'/')]]"));
        // Get all href attribute values on current page

        try
        {

            for (WebElement anchorTagElement : anchorTags) {
                hrefAttributeValues.add(anchorTagElement.getAttribute("href"));

//                // Webpage words processing - begin
//                WebElement htmlElement = driver.findElement(By.xpath("/html"));
//                String allTextOnPage = htmlElement.getText();
////            String newLinesRemoved = allTextOnPage.replaceAll("[\\s]+|[\\n]+|[\\u25BC]+|[\\&]+|:|\\\\|\\.|,|\\?|©|®|[(]+|[)]+", " ");
//                String newLinesRemoved = allTextOnPage.replaceAll("[^A-Za-z]+", " ");
//                String spaceDelimiterToOne = newLinesRemoved.replaceAll("\\s+", " ");
//                String[] stringArray = spaceDelimiterToOne.split("[\\s]");
//                for (String arrayValue : stringArray)
//                {
//                    WebsiteWordsRecord initialWordsRecord = new WebsiteWordsRecord();
//                    initialWordsRecord.setWord(arrayValue);
//                    initialWordsRecord.setWebsite(driver.getCurrentUrl());
//                    initialWordsRecord.setOccurrences(1);
//                    if (webpageWordsList.contains(initialWordsRecord))
//                    {
//                        int initialWordsrecordIndex = webpageWordsList.indexOf(initialWordsRecord);
//                        WebsiteWordsRecord updateRecord = new WebsiteWordsRecord();
//                        updateRecord = webpageWordsList.get(initialWordsrecordIndex);
//                        updateRecord.setOccurrences(updateRecord.getOccurrences()+1);
////                webpageWordsList.add(initialWordsrecordIndex, updateRecord);
//                    }
//                    else
//                    {
//                        webpageWordsList.add(initialWordsRecord);
//                    }
////            initialWordsRecord.setWord(null);
////            initialWordsRecord.setWebsite(null);
////            initialWordsRecord.setOccurrences(0);
//                }
//                // Webpage word processing - end

                // Populate Total Words Array List
//                for (WebsiteWordsRecord WebsiteWordsIndex : webpageWordsList)
//                {
//                    TotalWordsRecord totalRecord = new TotalWordsRecord();
//                    totalRecord.setWord(WebsiteWordsIndex.getWord());
//                    totalRecord.setOccurrences(WebsiteWordsIndex.getOccurrences());
//                    if (allWordsList.contains(totalRecord))
//                    {
//                        int totalWordsIndex = allWordsList.indexOf(totalRecord);
//                        TotalWordsRecord totalWordsRecordUpdate = new TotalWordsRecord();
//                        totalWordsRecordUpdate = allWordsList.get(totalWordsIndex);
//                        totalWordsRecordUpdate.setOccurrences(totalWordsRecordUpdate.getOccurrences() + WebsiteWordsIndex.getOccurrences());
//                    }
//                    else
//                    {
//                        allWordsList.add(totalRecord);
//                    }
//                    Thread.sleep(5);
//                }

            }

            return hrefAttributeValues;

        }

        catch(StaleElementReferenceException e)
        {

        }

        catch(NullPointerException e)
        {

        }

        return hrefAttributeValues;
    }
}
