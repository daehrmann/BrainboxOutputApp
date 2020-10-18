package com.example.brainboxtest;

import java.util.*;

public class Constants
{
    static ArrayList<Boolean> bb1RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb2RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb3RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb4RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb5RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb6RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb7RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb8RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb9RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb10RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb11RunStatus = new ArrayList<Boolean>();
    static ArrayList<Boolean> bb12RunStatus = new ArrayList<Boolean>();
    static boolean hasBeenInstantiated = false;

    public static void instantiateRunStatus()
    {
        if(hasBeenInstantiated == false)
        {
            for(int i = 0; i < 16; i++)
            {
                bb1RunStatus.add(false);
                bb2RunStatus.add(false);
                bb3RunStatus.add(false);
                bb4RunStatus.add(false);
                bb5RunStatus.add(false);
                bb6RunStatus.add(false);
                bb7RunStatus.add(false);
                bb8RunStatus.add(false);
                bb9RunStatus.add(false);
                bb10RunStatus.add(false);
                bb11RunStatus.add(false);
                bb12RunStatus.add(false);

            }
            hasBeenInstantiated = true;
        }
    }

    public static boolean getRunStatus(int brainbox, int index)
    {
        if(brainbox == 0)
        {
            return bb1RunStatus.get(index);
        }

        if(brainbox == 1)
        {
            return bb2RunStatus.get(index);
        }

        if(brainbox == 2)
        {
            return bb3RunStatus.get(index);
        }

        if(brainbox == 3)
        {
            return bb4RunStatus.get(index);
        }

        if(brainbox == 4)
        {
            return bb5RunStatus.get(index);
        }

        if(brainbox == 5)
        {
            return bb6RunStatus.get(index);
        }

        if(brainbox == 6)
        {
            return bb7RunStatus.get(index);
        }

        if(brainbox == 7)
        {
            return bb8RunStatus.get(index);
        }

        if(brainbox == 8)
        {
            return bb9RunStatus.get(index);
        }

        if(brainbox == 9)
        {
            return bb10RunStatus.get(index);
        }

        if(brainbox == 10)
        {
            return bb11RunStatus.get(index);
        }

        if(brainbox == 11)
        {
            return bb12RunStatus.get(index);
        }

        return false;
    }

    public static boolean setRunStatus(int brainbox, int index, boolean value)
    {
        if(brainbox == 0)
        {
            bb1RunStatus.set(index, value);
        }

        if(brainbox == 1)
        {
            bb2RunStatus.set(index, value);
        }

        if(brainbox == 2)
        {
            bb3RunStatus.set(index, value);
        }

        if(brainbox == 3)
        {
            bb4RunStatus.set(index, value);
        }

        if(brainbox == 4)
        {
            bb5RunStatus.set(index, value);
        }

        if(brainbox == 5)
        {
            bb6RunStatus.set(index, value);
        }

        if(brainbox == 6)
        {
            bb7RunStatus.set(index, value);
        }

        if(brainbox == 7)
        {
            bb8RunStatus.set(index, value);
        }

        if(brainbox == 8)
        {
            bb9RunStatus.set(index, value);
        }

        if(brainbox == 9)
        {
            bb10RunStatus.set(index, value);
        }

        if(brainbox == 10)
        {
            bb11RunStatus.set(index, value);
        }

        if(brainbox == 11)
        {
            bb12RunStatus.set(index, value);
        }

        return false;
    }
}
