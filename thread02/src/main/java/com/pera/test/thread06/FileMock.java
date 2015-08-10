package com.pera.test.thread06;

/**
 * Created by csq on 2015/8/7.
 */
public class FileMock {
    private String content[];
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < length; j++) {
                int indice = (int)Math.random();
                buffer.append((char)indice);
            }
            content[i] = buffer.toString();
        }
        index = 0;
    }


    public boolean hasMoreLines(){
        return index < content.length;
    }

    public String getLine(){
        if(hasMoreLines()){
            System.out.println("Mock:"+(content.length - index));
            return content[index++];
        }
        return null;
    }


}
