package com.stgconsulting;

import org.openqa.selenium.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Richard Harkins on 10/17/2016.
 */
public class WebPageCrawlerWithWords extends SeleniumWebdriverBaseClass implements Callable
{
    private String url;

    //    WebDriver driver = new HtmlUnitDriver();
    WebElement htmlElement = driver.findElement(By.xpath("/html"));
    //    WebElement htmlElement = driver.findElement(By.tagName("html"));
    String allTextOnPage = htmlElement.getText();
    List<WebElement> anchorTags = null;
    List<String> hrefAttributeValues = new ArrayList<String>();

    //    String newLinesRemoved = allTextOnPage.replaceAll("[\\s]+|[\\n]+|[\\u25BC]+|[\\&]+|:|\\\\|\\.|,|\\?|©|®|[(]+|[)]+", " ");
    String newLinesRemoved = allTextOnPage.replaceAll("[^A-Za-z]+", " ");
    String spaceDelimiterToOne = newLinesRemoved.replaceAll("\\s+", " ");
    String[] stringArray = spaceDelimiterToOne.split("[\\s]");

    public WebPageCrawlerWithWords(String url) throws IOException
    {
        this.url = url;
    }

    public String getURL()
    {
        return this.url;
    }

    public List<String> getHrefAttributeValues()
    {
        return this.hrefAttributeValues;
    }

    public String[] getAllTextOnPage()
    {
        return this.stringArray;
    }

    public void setHrefAtributeValues(List<String> inputHrefAttributeValues)
    {
        this.hrefAttributeValues = inputHrefAttributeValues;
    }

    public void setAllTextonPage(String inputAllTextonPage)
    {
        this.allTextOnPage = inputAllTextonPage;
    }

    public WebPageCrawlerWithWords call()throws StaleElementReferenceException, InterruptedException
    {
        driver.navigate().to(url);

//        anchorTags = driver.findElements(By.xpath(".//a[@href[starts-with(.,'https://www.skiutah.com') and not(contains(., '@@')) and not(contains(., '?'))]]"));
        anchorTags = driver.findElements(By.xpath(".//a[@href[starts-with(.,'https://www.skiutah.com') and not(contains(., '@@')) and not(contains(., 'blog')) and not(contains(., '?'))]]"));

        try
        {

            for (WebElement anchorTagElement : anchorTags)
            {
                hrefAttributeValues.add(anchorTagElement.getAttribute("href"));


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

        this.setHrefAtributeValues(hrefAttributeValues);
        this.setAllTextonPage(allTextOnPage);
        return this;
    }

}