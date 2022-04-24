package actions;


import classes.compare;
import classes.file;
//import classes.pop;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
//import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
//import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

//import java.io.File;
//import java.io.FileReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//import javax.swing.*;
//import javax.swing.filechooser.FileNameExtensionFilter;

public class Hello extends AnAction {

    //protected static final String EXTENT = ".txt";


    // FileNameExtensionFilter filt = new FileNameExtensionFilter()
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // Messages.showInfoMessage("Hi", "Trying");
        // file.showSaveDialog(frame.getFrame());
         //  final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);

        //runs the file selector to choose a file to compare it to
        //  file f = new file();

          //  f.actionPerformed(null);

            String pathName = "C:\\Users\\Cupcake\\Documents\\test.txt";// f.temp;




           //this creates an instance of the code on opened java file class
         Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
         Project project = e.getRequiredData(CommonDataKeys.PROJECT);
            Document document = editor.getDocument();
            String sample= null;
        String something = document.getText().toString();
      //  this is a tester to make sure that the class is being copied to the string correctly
       //  WriteCommandAction.runWriteCommandAction(project, () ->
         //        document.insertString(0,something)
       //   );
       //  this copies the java class to a string

        try {
            sample = path(pathName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String finalSample = sample;
        WriteCommandAction.runWriteCommandAction(project, () ->
                document.insertString(0, finalSample)
           );
        //this isn't necessary to the project but can be used for later modification
        //   Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
        // int start = primaryCaret.getSelectionStart();
        //  int end = primaryCaret.getSelectionEnd();
        compare comp = new compare();
        if(sample!= null) {
            comp.filesCompareByWord(sample, something);
        }





    }
     public String path(String pathName) throws IOException {
       String toCompare = null;

         Path filePath = Path.of(pathName);
        String content = Files.readString(filePath);
        try {
            FileReader fileReader
                    = new FileReader(pathName);

         //   System.out.println("Reading char by char : \n");
        //    int i;
        //    while ((i = fileReader.read()) != -1) {
               // System.out.print((char)i);
        //    }

            System.out.println("Reading using array : \n");
            char[] charArray = new char[10];
            fileReader.read(charArray);
          //  System.out.print(charArray);

            fileReader.close();
            //System.out.println("FileReader closed!");
        }
        catch (Exception e) {
            //System.out.println(e);
        }
       return content;
      }


}
