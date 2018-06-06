package com.angrybeaver.threadsandmemory;

import com.angryBeaver.threadsandmemory.Data;
import com.angryBeaver.threadsandmemory.DataWithLongName;
import com.angryBeaver.threadsandmemory.BigData;
import com.angryBeaver.threadsandmemory.DoubleData;
import com.angryBeaver.threadsandmemory.DoubleLong;
import com.angryBeaver.threadsandmemory.IntData;
import com.angryBeaver.threadsandmemory.DoubleIntData;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MemoryTest {
    private Integer runs = 1000000;
    private Data[] map1 = new Data[runs];
    private DataWithLongName[] map2 = new DataWithLongName[runs];
    private BigData[] map3 = new BigData[runs];
    private DoubleData[] map4 = new DoubleData[runs];
    private DoubleLong[] map5= new DoubleLong[runs];
    private IntData[] map6 = new IntData[runs];
    private DoubleIntData[] map7 = new DoubleIntData[runs];


    @Before
    public void clearMaps(){
        map1 = new Data[runs];
        map2 = new DataWithLongName[runs];
        map3 = new BigData[runs];
        map4 = new DoubleData[runs];
        map5 = new DoubleLong[runs];
        map6 = new IntData[runs];
        map7 = new DoubleIntData[runs];
    }

    @After
    public void readMaps(){
        for(Integer x = 0; x< runs; x++) {
            try {
                map1[x].getData();
                map2[x].getDataWithLongName();
                map3[x].getData();
                map4[x].getA();
                map4[x].getB();
                map4[x].getC();
                map4[x].getD();
                map5[x].getA();
                map6[x].getData();
                map7[x].getA();
            }catch(Exception e){
                //
            }
        }
    }

    @Test
    public void longName(){
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            DataWithLongName t = new DataWithLongName();
            t.setDataWithLongName((byte) 0);
            map2[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("LongName Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }

    @Test
    public void fullByte() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            Data t = new Data();
            t.setData((byte) 127);
            map1[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("FullByte Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }
    @Test
    public void zeroByte() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            Data t = new Data();
            t.setData((byte) 0);
            map1[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("ZeroByte Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }
    @Test
    public void notSetByte() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            Data t = new Data();
            map1[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("NotSetByte Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }
    @Test
    public void zeroLong() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            BigData t = new BigData();
            t.setData((byte) 0);
            map3[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("ZeroLong Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }
    @Test
    public void notSetLong() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            BigData d = new BigData();
            map3[x] = d;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("NotSetLong Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }
    @Test
    public void notSetDouble() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            DoubleData t = new DoubleData();
            map4[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("NotSetDouble Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }
    @Test
    public void setDouble() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            DoubleData t = new DoubleData();
            t.setA((byte) 22);
            t.setB((byte) 127);
            t.setC((byte) 0);
            t.setD((byte) 42);
            map4[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("SetDouble Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }
    @Test
    public void notSetDoubleLong(){
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            DoubleLong t = new DoubleLong();
            map5[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("NotSetDoubleLong Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }
    @Test
    public void notSetIntData(){
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            IntData t = new IntData();
            map6[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("NotSetInt Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }
    @Test
    public void notSetDoubleIntData(){
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        for (Integer x = 0; x < runs; x++) {
            DoubleIntData t = new DoubleIntData();
            map7[x] = t;
        }
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("NotSetDoubleInt Memory:" + (usedMemoryAfter - usedMemoryBefore)/runs);
    }

}
