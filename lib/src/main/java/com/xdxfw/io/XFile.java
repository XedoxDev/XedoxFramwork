package com.xdxfw.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class XFile extends File {

    public XFile(String name) {
        super(name);
    }

    public XFile(File path, String name) {
        super(path, name);
    }

    public XFile(String path, String name) {
        super(new File(path), name);
    }

    public void write(String text) {
        try {
            FileWriter writer = new FileWriter(this);
            writer.write(text);
        } catch (Exception err) {

        }
    }

    public String read() {
        try {
            var reader = new BufferedReader(new FileReader(this));
            var buffer = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        return "null";
    }
}
