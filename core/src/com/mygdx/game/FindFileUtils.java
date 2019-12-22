package com.mygdx.game;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;

public class FindFileUtils { // class tha recursivly finds all files in given directory.
 static  ArrayList<File>   files= new ArrayList<File>();
 static  ArrayList<File> directories= new ArrayList<File>();
  static ArrayList<String> fileNames= new ArrayList<String>();
  static Character exclude= new Character('?'); // exclude files or folders  that start with this char








    public static  ArrayList<File> findFiles(String path){ // gets all files in a given directory ignores files and directories that start with exclude char.
        File folder= new File(path);
        File [] listOfFiles=folder.listFiles((FileFilter) null);

        int size=listOfFiles.length;
        for (int count = 0; count < size; count++) {
            if(!(listOfFiles[count].getName().charAt(0)==exclude)) {
                if (listOfFiles[count].isFile()) {
                    files.add(listOfFiles[count]);
                    fileNames.add(listOfFiles[count].getName());
                } else if (listOfFiles[count].isDirectory()) {


                    findFiles(listOfFiles[count].getPath());


                }

            }

        }





        return files;

    }


    public static  ArrayList<String> getSingleFileNames( String path){ // returns  a list of unique file names  in a given directory

        findFiles(path);



        Collections.sort(fileNames);
         int size=fileNames.size();
        String name1=fileNames.get(0);

        ArrayList<String> singleNames= new ArrayList<String>(100);
        singleNames.add(name1);
        for(int count=1; count<size; count++){
            String name2=fileNames.get(count);

            if(!(name1.equals(name2))){
                singleNames.add(name2);

            }


        }
       return singleNames;




    }





    public static  ArrayList<File> findDirectories(String path){ // gets all  directories in a given directiory including subDirectories
        File folder= new File(path);
        File [] listOfFiles=folder.listFiles();
        int size=listOfFiles.length;
        for (int count = 0; count < size; count++) {
            if (listOfFiles[count].isDirectory()) { // if it is a  directory search it by recursivly calling this method.
                directories.add(listOfFiles[count]);
                findDirectories(listOfFiles[count].getPath());
            }
        }
        return directories;
    }


    public static   String getExtensionOfFile(File file) // returns the extension of given file like .png or .tmx ECT.
    {
        String fileExtension="";
        // Get file Name first
        String fileName=file.getName();

        // If fileName do not contain "." or starts with "." then it is not WoodWand valid file
        if(fileName.contains(".") && fileName.lastIndexOf(".")!= 0)
        {
            fileExtension=fileName.substring(fileName.lastIndexOf(".")+1);
        }

        return fileExtension;
    }




    public static  ArrayList<String> getFileNames(String path) {// returns a list of all file names in a given directory
        findFiles(path);



        return fileNames;
    }




    public char getExclude() {
        return exclude;
    }

    public void setExclude(char exclude) {
        this.exclude = exclude;
    }
}
