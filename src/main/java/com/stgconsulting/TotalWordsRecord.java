package com.stgconsulting;

/**
 * Created by Richard Harkins on 7/29/2016.
 */
public class TotalWordsRecord
{
    String word;
    long occurrences;

    public String getWord()
    {
        return this.word;
    }

    public long getOccurrences()
    {
        return this.occurrences;
    }

    public void setWord(String inputWord)
    {
        this.word = inputWord;
    }

    public void setOccurrences(long inputOccurrences)
    {
        this.occurrences = inputOccurrences;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean equalsTest = false;
        if (((TotalWordsRecord) obj).word.equals(this.word))
        {
            equalsTest = true;
        }
        return equalsTest;
    }
}
