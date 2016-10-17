package com.stgconsulting;

/**
 * Created by Richard Harkins on 7/29/2016.
 */
public class WebsiteWordsRecord
{
    String word;
    String website;
    long occurrences;

    public String getWord()
    {
        return this.word;
    }

    public String getWebsite()
    {
        return this.website;
    }

    public long getOccurrences()
    {
        return this.occurrences;
    }

    public void setWord(String inputWord)
    {
        this.word = inputWord;
    }

    public void setWebsite(String inputWebsite)
    {
        this.website = inputWebsite;
    }

    public void setOccurrences(long inputOccurrences)
    {
        this.occurrences = inputOccurrences;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean equalsTest = false;
        if (((WebsiteWordsRecord) obj).word.equals(this.word) && ((WebsiteWordsRecord) obj).website.equals(this.website))
        {
            equalsTest = true;
        }
        return equalsTest;
    }
}
