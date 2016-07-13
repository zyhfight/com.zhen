package IOTestC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Externalizable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.PushbackReader;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import IOTestC.CMain;


public class IOMain
{
    public static void listAll(File fileDir)
    {
        
        String[] strList = fileDir.list();
        for (String filename : strList)
        {
            System.out.println(filename);
            File fileDirTmp = new File(fileDir.getName()+ System.getProperty("file.separator") + filename);
            if (fileDirTmp.isDirectory())
            {
                CMain.listAll(fileDirTmp);
            }
        }  
    }

  public static void insert(String fileName, long pos, String insertContent) throws IOException
  {
          File file = File.createTempFile("insertFile", ".tmp");
          file.deleteOnExit();
          
          try( RandomAccessFile targetRaf = new RandomAccessFile(fileName, "rw");
                  RandomAccessFile tmpRaf = new RandomAccessFile(file, "rw"))
          {
              byte[] buf = new byte[1024];
              int hasread = 0;
              targetRaf.seek(pos);
              while ((hasread = targetRaf.read(buf)) > 0)
              {
                  tmpRaf.write(buf, 0, hasread);
              }
  
              targetRaf.seek(pos);
              targetRaf.write(insertContent.getBytes());
              
              tmpRaf.seek(0);
              while ((hasread = tmpRaf.read(buf)) > 0)
              {
                  System.out.println(new String(buf, 0, hasread));
                  targetRaf.write(buf, 0, hasread);
              }
          }
          catch (IOException e)
          {
              e.printStackTrace();
          }
  }
 
//    public static void insert(String fileName, long pos, String insertContent)
//            throws IOException
//    {
//        File tmp = File.createTempFile("tmp", null);
//        tmp.deleteOnExit();
//        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
//        // ʹ����ʱ�ļ�����������������
//                FileOutputStream tmpOut = new FileOutputStream(tmp);
//                FileInputStream tmpIn = new FileInputStream(tmp))
//        {
//            raf.seek(pos);
//            // ------������뽫����������ݶ�����ʱ�ļ��б���------
//            byte[] bbuf = new byte[64];
//            // ���ڱ���ʵ�ʶ�ȡ���ֽ���
//            int hasRead = 0;
//            // ʹ��ѭ����ʽ��ȡ�����������
//            while ((hasRead = raf.read(bbuf)) > 0)
//            {
//                // ����ȡ������д����ʱ�ļ�
//                tmpOut.write(bbuf, 0, hasRead);
//            }
//            // ----------��������������----------
//            // ���ļ���¼ָ�����¶�λ��posλ��
//            raf.seek(pos);
//            // ׷����Ҫ���������
//            raf.write(insertContent.getBytes());
//            // ׷����ʱ�ļ��е�����
//            while ((hasRead = tmpIn.read(bbuf)) > 0)
//            {
//                raf.write(bbuf, 0, hasRead);
//            }
//        }
//    }
  
    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
      
//        System.out.println(args.length);
//        for (String arg : args)
//        {
//            System.out.println(arg);
//        }
        
        
//        // System.in�����׼���룬���Ǽ�������
//        Scanner sc = new Scanner(System.in);
//        sc.useDelimiter("\n");
//        while(sc.hasNext())
//        {
//            // ���������
//            System.out.println("��������������ǣ�"
//                + sc.next());
//        }     
        
//        InputStream in = System.in;
//        byte[] buffer = new byte[256];
//        int readnu = 0;
//        while((readnu = in.read(buffer)) > 0)
//        {
//            System.out.println(new String(buffer, 0, readnu-1));
//        }
        
        // ��ȡϵͳ���еĻ�������
//        Map<String,String> env = System.getenv();
//        for (String name : env.keySet())
//        {
//            System.out.println(name + " ---> " + env.get(name));
//        } 
        
//        System.out.println(System.getenv("TEMP"));
    
//        Properties props = System.getProperties();
//        props.store(new FileOutputStream("props.txt"), "---jvm props--");
//        System.out.println(System.getProperty("user.dir"));
        
//        // ��ȡJava�������������ʱ����
//        Runtime rt = Runtime.getRuntime();
//        System.out.println("������������"+ rt.availableProcessors());
//        System.out.println("�����ڴ�����"+ rt.freeMemory());
//        //������ʱ��ͻ��������ĴӲ���ϵͳ����- Xms���涨����ڴ���
//        System.out.println("���ڴ�����"+ rt.totalMemory());
//        //û�����-Xmx���� 64M java -cp ClassPath -Xmx512m ClassName
//        System.out.println("��������ڴ�����"+ rt.maxMemory());     
        
//        Runtime rt = Runtime.getRuntime();
//        // ���м��±�����
//        rt.exec("calc.exe");
        
//        System.out.println(System.getProperty("user.dir"));
//        if (args.length > 0)
//        {
//            File file = new File("props.txt");
//
//            System.out.println("�ļ���Ŀ¼�Ƿ����:" + file.exists());
//            System.out.println("���ļ���:" + file.isFile());
//            System.out.println("��Ŀ¼��:" + file.isDirectory());
//            System.out.println("����:" + file.getName());
//            System.out.println("·��: " + file.getPath());
//            System.out.println("����·��: " + file.getAbsolutePath());
//            System.out.println("����޸�ʱ��:" + file.lastModified());
//            System.out.println("�ļ���С:" + file.length() + "�ֽ�");
////        }       
        
//        // �Ե�ǰ·��������һ��File����
//        File file = new File(".");
//        // ֱ�ӻ�ȡ�ļ��������һ��
//        System.out.println(file.getName());
//        // ��ȡ���·���ĸ�·�����ܳ�������������null
//        System.out.println(file.getParent());
//        // ��ȡ����·��
//        System.out.println(file.getAbsoluteFile());
//        // ��ȡ��һ��·��
//        System.out.println(file.getAbsoluteFile().getParent());
//        System.out.println(file.getAbsoluteFile().getName());
        
//        File tmpFile = File.createTempFile("aaa", ".txt", new File("."));
//        tmpFile.deleteOnExit();
        
//        File newFile = new File("aa\\bb");
//        //newFile.createNewFile();
//        //newFile.deleteOnExit();
//        newFile.mkdirs();
//        newFile.deleteOnExit();

//        //System.out.println("��Ŀ¼��:" + file.isDirectory());
//        File file = new File(".");
//        String[] fileList = file.list();
//        System.out.println("====��ǰ·���������ļ���·������====");
//        for (String fileName : fileList)
//        {
//            System.out.println(fileName);
//        }        
        
//        // listRoots()��̬�����г����еĴ��̸�·����
//        File[] roots = File.listRoots();
//        System.out.println("====ϵͳ���и�·������====");
//        for (File root : roots)
//        {
//            System.out.println(root);
//        }
        
//        File file = new File(".");
//        String[] fileList = file.list(new MyFilenameFilter());
//        System.out.println("====��ǰ·���������ļ���·������====");
//        for (String fileName : fileList)
//        {
//            System.out.println(fileName);
//        }      
        
//        File file = new File(".");
//        File[] fileList = file.listFiles(new MyFileFilter());
//        System.out.println("====��ǰ·���������ļ���·������====");
//        for (File fileName : fileList)
//        {
//            System.out.println(fileName.getName());
//        }    
        
//        // �����ֽ�������
//        FileInputStream fis = new FileInputStream("props.txt");
//        // ����һ������Ϊ1024�ġ���Ͳ��
//        byte[] bbuf = new byte[1024];
//        // ���ڱ���ʵ�ʶ�ȡ���ֽ���
//        int hasRead = 0;
//        // ʹ��ѭ�����ظ���ȡˮ������
//        while ((hasRead = fis.read(bbuf)) > 0)
//        {
//            System.out.println("\n---->:  " + hasRead);
//
//            // ȡ������Ͳ����ˮ�Σ��ֽڣ������ֽ�����ת�����ַ������룡
//            System.out.print(new String(bbuf, 0, hasRead));
//        }
//        // �ر��ļ�������������finally�������ȫ
//        fis.close();
        
//        FileReader fr = null;
//        try
//        {
//            fr = new FileReader("props.txt");
//            // ����һ������Ϊ32�ġ���Ͳ��
//            char[] cbuf = new char[32];
//            // ���ڱ���ʵ�ʶ�ȡ���ַ���
//            int hasRead = 0;
//            // ʹ��ѭ�����ظ���ȡˮ������
//            while ((hasRead = fr.read(cbuf)) > 0)
//            {
//                System.out.println("\n---->:  " + hasRead);
//                // ȡ������Ͳ����ˮ�Σ��ַ��������ַ�����ת�����ַ������룡
//                System.out.print(new String(cbuf, 0, hasRead));
//            }
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }
//        finally
//        {
//            if (fr != null)
//            {
//                fr.close();
//            }
//        }
//        
 
//        try (
//                // �����ֽ�������
//                FileInputStream fis = new FileInputStream("props.txt");
//                // �����ֽ������
//                FileOutputStream fos = new FileOutputStream("newFile.txt"))
//        {
//            byte[] bbuf = new byte[1000];
//            int hasRead = 0;
//            // ѭ������������ȡ������
//            while ((hasRead = fis.read(bbuf)) > 0)
//            {
//                // ÿ��ȡһ�Σ���д���ļ�����������˶��٣���д���١�
//                fos.write(bbuf, 0, hasRead);
//            }
//        }
//        catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//        }
        
//        try(
//                    FileWriter fw = new FileWriter("poem.txt", true);)
////                  FileWriter fw = new FileWriter("poem.txt"))
//              {
//                  fw.write("��ɪ - ������" + System.getProperty("line.separator"));
//                  fw.write("��ɪ�޶���ʮ�ң�һ��һ��˼���ꡣ\r\n");
//                  fw.write("ׯ�������Ժ��������۴����жž顣\r\n");
//                  fw.write("�׺����������ᣬ������ů�����̡�\r\n");
//                  fw.write("����ɴ���׷�䣬ֻ�ǵ�ʱ���Ȼ��\r\n");
//              }
//              catch (IOException ioe)
//              {
//                  ioe.printStackTrace();
//              }
   
//            String src = "����������һ���Ҹ�����\n"
//                + "ι��������������\n"
//                + "�������𣬹�����ʳ���߲�\n"
//                + "����һ�����ӣ��泯�󺣣���ů����\n"
//                + "�������𣬺�ÿһ������ͨ��\n"
//                + "���������ҵ��Ҹ�\n";
//            char[] buffer = new char[32];
//            int hasRead = 0;
//            try(
//                StringReader sr = new StringReader(src))
//            {
//                // ����ѭ����ȡ�ķ��ʶ�ȡ�ַ���
//                while((hasRead = sr.read(buffer)) > 0)
//                {
//                    System.out.println("\n---->:  " + hasRead);
//                    System.out.print(new String(buffer ,0 , hasRead));
//                }
//            }
//            catch (IOException ioe)
//            {
//                ioe.printStackTrace();
//            }
//            try(
//                // ����StringWriterʱ��ʵ������һ��StringBuffer��Ϊ����ڵ�
//                // ����ָ����20����StringBuffer�ĳ�ʼ����
//                StringWriter sw = new StringWriter())
//            {
//                // ����StringWriter�ķ���ִ�����
//                sw.write("��һ�������������磬\n");
//                sw.write("����Զ������,\n");
//                sw.write("����������ĺ��ӣ�\n");
//                sw.write("���й���ľ���\n");
//                System.out.println("----������sw���ַ����ڵ��������----");
//                // ʹ��toString()��������StringWriter���ַ����ڵ������
//                System.out.println(sw.toString());
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
        
//        try (
//                // ��Sytem.in����ת����Reader����
//                InputStreamReader reader = new InputStreamReader(System.in);
//                // ����ͨReader��װ��BufferedReader
//                BufferedReader br = new BufferedReader(reader))
//        {
//            String line = null;
//            // ����ѭ����ʽ��һ��һ�еĶ�ȡ
//            while ((line = br.readLine()) != null)
//            {
//                // �����ȡ���ַ���Ϊ"exit"�������˳�
//                if (line.equals("exit"))
//                {
//                    System.exit(1);
//                }
//                // ��ӡ��ȡ������
//                System.out.println("��������Ϊ:" + line);
//            }
//        }
//        catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//        }    
        
//        try (
//                // ��Sytem.in����ת����Reader����
//                OutputStreamWriter writer = new OutputStreamWriter(System.out);
//                // ����ͨReader��װ��BufferedReader
//                BufferedWriter bw = new BufferedWriter(writer))
//         {
//             String line = null;
//             bw.write("����һ��ѧϰ��");
//             bw.newLine();
//             bw.write("����һ���棡");
//             bw.newLine();
//         }
//         catch (IOException ioe)
//         {
//             ioe.printStackTrace();
//         }   
  
//        try(
//                FileOutputStream fos = new FileOutputStream("test.txt");
//                PrintStream ps = new PrintStream(fos))
//            {
//                // ʹ��PrintStreamִ�����
//                ps.println("��ͨ�ַ���");
//                ps.format("abcd=%10d%s", 10, System.getProperty("line.separator"));
//                // ֱ��ʹ��PrintStream�������
//                ps.println(new CMain());
//            }
//            catch (IOException ioe)
//            {
//                ioe.printStackTrace();
//            }
        
//        PushbackReader pr = new PushbackReader(new FileReader("props.txt"), 64);
//        String strBuf = "abcde12345";
//        pr.unread(strBuf.toCharArray());
//        
//        char[] buf = new char[15];
//        int hasRead = pr.read(buf);
//        if (hasRead > 0)
//        {
//            System.out.println(new String(buf, 0, hasRead));     
//        }  
//        
//        hasRead = pr.read(buf);
//        if (hasRead > 0)
//        {
//            System.out.println(new String(buf, 0, hasRead));     
//        }     
        
//        try(
//                FileInputStream fis = new FileInputStream("RedirectIn.java"))
//            {
//                // ����׼�����ض���fis������
//                System.setIn(fis);
//                // ʹ��System.in����Scanner�������ڻ�ȡ��׼����
//                Scanner sc = new Scanner(System.in);
//                // ��������һ�н�ֻ�ѻس���Ϊ�ָ���
//                sc.useDelimiter("\n");
//                // �ж��Ƿ�����һ��������
//                while(sc.hasNext())
//                {
//                    // ���������
//                    System.out.println("��������������ǣ�" + sc.next());
//                }
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
        
//        try(
//                // һ���Դ���PrintStream�����
//                //PrintStream ps = new PrintStream(new FileOutputStream("out.txt")))
//                PrintStream ps = new PrintStream("out.txt"))
//            {
//                // ����׼����ض���ps�����
//                System.setOut(ps);
//                // ���׼������һ���ַ���
//                System.out.println("��ͨ�ַ���");
//                // ���׼������һ������
//                System.out.println(new CMain());
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
 
//        // ����javac����������и�������ӽ���
//        Process p = Runtime.getRuntime().exec("java.exe");
//        try(
//            // ��p���̵Ĵ���������BufferedReader����
//            // ����������Ա�����������������p�������������
//            BufferedReader br = new BufferedReader(new
//                InputStreamReader(p.getErrorStream())))
//        {
//            String buff = null;
//            // ��ȡѭ����ʽ����ȡp���̵Ĵ������
//            while((buff = br.readLine()) != null)
//            {
//                System.out.println(buff);
//            }
//        }        

//        // ����java ReadStandard����������и�������ӽ���
//        Process p = Runtime.getRuntime().exec("java -classpath bin IOTestC.ReadStandard");
//        try (
//        // ��p���̵����������PrintStream����
//        // ���������Ա����������������p��������������
//        PrintStream ps = new PrintStream(p.getOutputStream()))
//        {
//            // ��ReadStandard����д�����ݣ���Щ���ݽ���ReadStandard��ȡ
//            ps.println("��ͨ�ַ���");
//            ps.println(new CMain());
//        }

//        try (RandomAccessFile raf = new RandomAccessFile("out.txt", "r"))
//        {
//            // ��ȡRandomAccessFile�����ļ�ָ���λ�ã���ʼλ����0
//            System.out.println("RandomAccessFile���ļ�ָ��ĳ�ʼλ�ã�"+ raf.getFilePointer());
//            // �ƶ�raf���ļ���¼ָ���λ��
//            raf.seek(0);
//            byte[] bbuf = new byte[1024];
//            // ���ڱ���ʵ�ʶ�ȡ���ֽ���
//            int hasRead = 0;
//            // ʹ��ѭ�����ظ���ȡˮ������
//            while ((hasRead = raf.read(bbuf)) > 0)
//            {
//                System.out.println("--->hasread: " + hasRead);
//                // ȡ������Ͳ����ˮ�Σ��ֽڣ������ֽ�����ת�����ַ������룡
//                System.out.print(new String(bbuf, 0, hasRead));
//            }
//            
//            String strLine = null;
//            while ((strLine = raf.readLine()) != null)
//            {
//                // ȡ������Ͳ����ˮ�Σ��ֽڣ������ֽ�����ת�����ַ������룡
//                System.out.println(strLine);
//            }
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }
        
//        try(
//                //�Զ���д��ʽ��һ��RandomAccessFile����
//                RandomAccessFile raf = new RandomAccessFile("out.txt" , "rw"))
//            {
//                //����¼ָ���ƶ���out.txt�ļ������
//                raf.seek(raf.length());
//                byte[] buff = new String("׷�ӵ����ݣ�\r\n").getBytes();
//                raf.write(buff);
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
        
//        try(
//                // ����һ��ObjectOutputStream�����
//                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt")))
//            {
//                Person per = new Person("�����", 500);
//                // ��per����д�������
//                oos.writeObject(per);
//            }
//            catch (IOException ex)
//            {
//                ex.printStackTrace();
//            }
   
//        try(
//                // ����һ��ObjectInputStream������
//                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt")))
//            {
//                // ���������ж�ȡһ��Java���󣬲�����ǿ������ת��ΪPerson��
//                Person p = (Person)ois.readObject();
//                System.out.println("����Ϊ��" + p.getName()
//                    + "\n����Ϊ��" + p.getAge());
//            }
//            catch (Exception ex)
//            {
//                ex.printStackTrace();
//            }
        
//        try (
//            // ����һ��ObjectOutputStream�����
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt")))
//        {
//            Person per = new Person("�����", 500);
//            Teacher t1 = new Teacher("��ɮ", per);
//            Teacher t2 = new Teacher("������ʦ", per);
//            // ���ν��ĸ�����д�������
//            oos.writeObject(t1);
//            oos.writeObject(t2);
//            oos.writeObject(per);
//            oos.writeObject(t2);
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        } 
        
//        try (
//            // ����һ��ObjectInputStream�����
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt")))
//        {
//            // ���ζ�ȡObjectInputStream�������е��ĸ�����
//            Teacher t1 = (Teacher) ois.readObject();
//            Teacher t2 = (Teacher) ois.readObject();
//            Person p = (Person) ois.readObject();
//            Teacher t3 = (Teacher) ois.readObject();
//            // ���true
//            System.out.println("t1��student���ú�p�Ƿ���ͬ��" + (t1.getStudent() == p));
//            // ���true
//            System.out.println("t2��student���ú�p�Ƿ���ͬ��" + (t2.getStudent() == p));
//            // ���true
//            System.out.println("t2��t3�Ƿ���ͬһ������" + (t2 == t3));
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
        
//        try(
//                // ����һ��ObjectOutputStream������
//                ObjectOutputStream oos = new ObjectOutputStream(
//                    new FileOutputStream("mutable.txt"));
//                // ����һ��ObjectInputStream������
//                ObjectInputStream ois = new ObjectInputStream(
//                    new FileInputStream("mutable.txt")))
//            {
//                Person per = new Person("�����", 500);
//                // ϵͳ��per����ת���ֽ����в����
//                oos.writeObject(per);
//                // �ı�per�����nameʵ������
//                per.setName("��˽�");
//                // ϵͳֻ��������л���ţ����Ըı���name���ᱻ���л�
//                oos.writeObject(per);
//                Person p1 = (Person)ois.readObject();    //��
//                Person p2 = (Person)ois.readObject();    //��
//                // �������true���������л���p1����p2
//                System.out.println(p1 == p2);
//                // ������Ȼ�������"�����"�����ı���ʵ������û�б����л�
//                System.out.println(p2.getName());
//            }
//            catch (Exception ex)
//            {
//                ex.printStackTrace();
//            }        

//        try (
//        // ����һ��ObjectOutputStream�����
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
//                "object.txt")))
//        {
//            Person per = new Person("abcd", 500);
//            // ��per����д�������
//            oos.writeObject(per);
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }

//        try (
//        // ����һ��ObjectInputStream������
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
//                "object.txt")))
//        {
//            // ���������ж�ȡһ��Java���󣬲�����ǿ������ת��ΪPerson��
//            Person p = (Person) ois.readObject();
//            System.out.println("����Ϊ��" + p.getName() + "\n����Ϊ��" + p.getAge());
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
        
//        // ����Buffer
//        CharBuffer buff = CharBuffer.allocate(8); // ��
//        System.out.println("capacity: " + buff.capacity());
//        System.out.println("limit: " + buff.limit());
//        System.out.println("position: " + buff.position());
//        // ����Ԫ��
//        buff.put('a');
//        buff.put('b');
//        buff.put('c'); // ��
//        System.out.println("��������Ԫ�غ�position = " + buff.position());
//        // ����flip()����
//        buff.flip(); // ��
//        System.out.println("ִ��flip()��limit = " + buff.limit());
//        System.out.println("position = " + buff.position());
//        // ȡ����һ��Ԫ��
//        System.out.println("��һ��Ԫ��(position=0)��" + buff.get()); // ��
//        System.out.println("ȡ��һ��Ԫ�غ�position = " + buff.position());
//        // ����clear����
//        buff.clear(); // ��
//        System.out.println("ִ��clear()��limit = " + buff.limit());
//        System.out.println("ִ��clear()��position = " + buff.position());
//        System.out.println("ִ��clear()�󣬻��������ݲ�û�б������" + "������Ԫ��Ϊ��" + buff.get(2)); // ��
//        System.out.println("ִ�о��Զ�ȡ��position = " + buff.position());
                
//        try(
//                // �����ļ�������
//                FileInputStream fis = new FileInputStream("props.txt");
//                // ����һ��FileChannel
//                FileChannel fcin = fis.getChannel())
//            {
//                // ����һ��ByteBuffer���������ظ�ȡˮ
//                ByteBuffer bbuff = ByteBuffer.allocate(256);
//                // ��FileChannel�����ݷ���ByteBuffer��
//                while( fcin.read(bbuff) != -1 )
//                {
//                    // ����Buffer�Ŀհ���
//                    bbuff.flip();
//                    // ����Charset����
//                    //Charset charset = Charset.forName("GBK");
//                    // ����������(CharsetDecoder)����
//                    //CharsetDecoder decoder = charset.newDecoder();
//                    // ��ByteBuffer������ת��
//                    //CharBuffer cbuff = decoder.decode(bbuff);
//                    byte[] bBbuf = bbuff.array(); 
//                    System.out.print(new String(bBbuf));
//                    // ��Buffer��ʼ����Ϊ��һ�ζ�ȡ������׼��
//                    bbuff.clear();
//                }
//            }        
        
//        File f = new File("props.txt");
//        try(
//            // ����FileInputStream���Ը��ļ�����������FileChannel
//            FileChannel inChannel = new FileInputStream(f).getChannel();
//            // ���ļ����������FileBuffer�����Կ������
//            FileChannel outChannel = new FileOutputStream("a.txt")
//                .getChannel())
//        {
//            // ��FileChannel���ȫ������ӳ���ByteBuffer
//            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY , 0 , f.length());   // ��
//            // ʹ��GBK���ַ���������������
//            //Charset charset = Charset.forName("GBK");
//            // ֱ�ӽ�buffer�������ȫ�����
//            outChannel.write(buffer);     // ��
//            // �ٴε���buffer��clear()��������ԭlimit��position��λ��
//            buffer.clear();
//            // ����������(CharsetDecoder)����
//            //CharsetDecoder decoder = charset.newDecoder();
//            // ʹ�ý�������ByteBufferת����CharBuffer
//            //CharBuffer charBuffer =  decoder.decode(buffer);
//            // CharBuffer��toString�������Ի�ȡ��Ӧ���ַ���
//            //System.out.println(charBuffer);         
//            byte[] bBbuf = buffer.array(); 
//            System.out.println(new String(bBbuf));
//            
//        }
//        catch (IOException ex)
//        {
//            ex.printStackTrace();
//        }

//        File f = new File("a.txt");
//        try(
//            // ����һ��RandomAccessFile����
//            RandomAccessFile raf = new RandomAccessFile(f, "rw");
//            // ��ȡRandomAccessFile��Ӧ��Channel
//            FileChannel randomChannel = raf.getChannel())
//        {
//            // ��Channel����������ӳ���ByteBuffer
//            ByteBuffer buffer = randomChannel.map(FileChannel
//                .MapMode.READ_ONLY, 0 , f.length());
//            // ��Channel�ļ�¼ָ���ƶ������
//            randomChannel.position(f.length());
//            // ��buffer�������������
//            randomChannel.write(buffer);    
        
//        // ��ȡJava֧�ֵ�ȫ���ַ���
//        SortedMap<String,Charset>  map = Charset.availableCharsets();
//        for (String alias : map.keySet())
//        {
//            // ����ַ����ı����Ͷ�Ӧ��Charset����
//            System.out.println(alias + "----->"
//                + map.get(alias));
//        }
 
//        // �����������Ķ�Ӧ��Charset
//        Charset cn = Charset.forName("GBK");
//        // ��ȡcn�����Ӧ�ı������ͽ�����
//        CharsetEncoder cnEncoder = cn.newEncoder();
//        CharsetDecoder cnDecoder = cn.newDecoder();
//        // ����һ��CharBuffer����
//        CharBuffer cbuff = CharBuffer.allocate(8);
//        cbuff.put('��');
//        cbuff.put('��');
//        cbuff.put('��');
//        cbuff.flip();
//        // ��CharBuffer�е��ַ�����ת�����ֽ�����
//        ByteBuffer bbuff = cnEncoder.encode(cbuff);
//        // ѭ������ByteBuffer�е�ÿ���ֽ�
//        for (int i = 0; i < bbuff.capacity() ; i++)
//        {
//            System.out.print(bbuff.get(i) + " ");
//        }
//        // ��ByteBuffer�����ݽ�����ַ�����
//        System.out.println("\n" + cnDecoder.decode(bbuff));       
        
//        try(
//                // ʹ��FileOutputStream��ȡFileChannel
//                FileChannel channel = new FileOutputStream("a.txt")
//                    .getChannel())
//            {
//                // ʹ�÷�����ʽ��ʽ��ָ���ļ�����
//                FileLock lock = channel.tryLock();
//                // ������ͣ10s
//                Thread.sleep(10000);
//                // �ͷ���
//                lock.release();    
        

//        String strA = "��";
//        byte[] bt = strA.getBytes("UnicodeLittle");
//        
//        FileWriter fw = new FileWriter("test.out");
//        
//        char ch = '��';
//        fw.write(ch);
//        fw.close();
        
//        FileInputStream fi = new FileInputStream("tt.out");
//        byte[] bt2 = new byte[100];
//        fi.read(bt2);      
        
//        int n;
//        FileReader fr = new FileReader("tt.out");
//        char[] bt2 = new char[100];
//        n = fr.read(bt2); 
//        
//        FileWriter fw2 = new FileWriter("tt2.out");
//        fw2.write(bt2, 0, n); 
//        fr.close();
//        fw2.close();
        
//        OperatIniFile op = new OperatIniFile("t3.out");
//        String strVal = op.readItem("RUN", "c1");
//        System.out.println(strVal);
//        op.close();
//        
//        OperatIniFile op2 = new OperatIniFile("t3.out");
//        System.out.println(op2.deleteItem("RUN", "c1"));
        
          OperatIniFile op = new OperatIniFile("t3.out");
          System.out.println(op.addItem3("Common1", "d1", "123"));
          
    }
}

//class MyFilenameFilter implements FilenameFilter
//{
//    public boolean accept(File dir, String name) 
//    {
//        //System.out.println("dir: " + dir + " name: " + name);
//        if (name.startsWith("."))
//            return true;
//        return false;
//    }
//    
//}

//class MyFileFilter implements FileFilter
//{
//    public boolean accept(File pathname) 
//    {
//        //System.out.println("path: " + pathname.getParent() + " name: " + pathname.getName());
//        if (pathname.getName().startsWith("."))
//            return true;
//        return false;
//    }   
//}

//class Person implements Serializable
//{
//    private String name;
//    private int age;
//    //static private int age;
//    //transient private int age;
//     
//    // ע��˴�û���ṩ�޲����Ĺ�����!
//    public Person(String name , int age)
//    {
//        System.out.println("�в����Ĺ�����");
//        this.name = name;
//        this.age = age;
//    }
//    // ʡ��name��age��setter��getter����
//
//    // name��setter��getter����
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//    public String getName()
//    {
//        return this.name;
//    }
//
//    // age��setter��getter����
//    public void setAge(int age)
//    {
//        this.age = age;
//    }
//    public int getAge()
//    {
//        return this.age;
//    }
//}
//
//class Teacher implements java.io.Serializable
//{
//    private String name;
//    private Person student;
//
//    public Teacher(String name, Person student)
//    {
//        this.name = name;
//        this.student = student;
//    }
//
//    // �˴�ʡ����name��student��setter��getter����
//
//    // name��setter��getter����
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public String getName()
//    {
//        return this.name;
//    }
//
//    // student��setter��getter����
//    public void setStudent(Person student)
//    {
//        this.student = student;
//    }
//
//    public Person getStudent()
//    {
//        return this.student;
//    }
//}

//class Person implements java.io.Serializable
//{
//    private String name;
//    private int    age;
//
//    // ע��˴�û���ṩ�޲����Ĺ�����!
//    public Person(String name, int age)
//    {
//        System.out.println("�в����Ĺ�����");
//        this.name = name;
//        this.age = age;
//    }
//
//    // ʡ��name��age��setter��getter����
//
//    // name��setter��getter����
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public String getName()
//    {
//        return this.name;
//    }
//
//    // age��setter��getter����
//    public void setAge(int age)
//    {
//        this.age = age;
//    }
//
//    public int getAge()
//    {
//        return this.age;
//    }
//
//    private void writeObject(java.io.ObjectOutputStream out) throws IOException
//    {
//        // ��nameʵ��������ֵ��ת��д���������
//        out.writeObject(new StringBuffer(name).reverse());
//        out.writeInt(age);
//    }
//
//    private void readObject(java.io.ObjectInputStream in) throws IOException,
//            ClassNotFoundException
//    {
//        // ����ȡ���ַ�����ת�󸳸�nameʵ������
//        StringBuffer temp = (StringBuffer)in.readObject();
//        this.name = temp.reverse().toString();
//        this.age = in.readInt();
//    }
//}

//class Person implements Externalizable
//{
//   // private static final long serialVersionUID = 42L;
//
//    private String name;
//    private int    age;
//    private String  memo;
//    // ע��˴���Ҫ�ṩ�޲����Ĺ�����!
//    public Person()
//    {
//        name = null;
//        age = 0;
//    }
//
//    public Person(String name, int age)
//    {
//        System.out.println("�в����Ĺ�����");
//        this.name = name;
//        this.age = age;
//    }
//
//    // ʡ��name��age��setter��getter����
//
//    // name��setter��getter����
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public String getName()
//    {
//        return this.name;
//    }
//
//    // age��setter��getter����
//    public void setAge(int age)
//    {
//        this.age = age;
//    }
//
//    public int getAge()
//    {
//        return this.age;
//    }
//
//    public void writeExternal(java.io.ObjectOutput out) throws IOException
//    {
//        // ��nameʵ��������ֵ��ת��д���������
//        out.writeObject(new StringBuffer(name).reverse());
//        out.writeInt(age);
//    }
//
//    public void readExternal(java.io.ObjectInput in) throws IOException,
//            ClassNotFoundException
//    {
//        // ����ȡ���ַ�����ת�󸳸�nameʵ������
//        this.name = ((StringBuffer) in.readObject()).reverse().toString();
//        this.age = in.readInt();
//        this.memo = "abcd";
//    }
//}

class OperatIniFile
{
    //BufferedReader br;
    String fileName;
    OperatIniFile(String fileName) throws FileNotFoundException
    {
        //br = new BufferedReader(new FileReader(fileName));
        this.fileName = fileName;
    }
    
//    void close() throws IOException
//    {
//       if (br != null)
//       {
//           br.close();
//       }
//    }
    
    String readItem(String strSector, String strItem) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String strLine = null;
        boolean bFindSector = false;
        String strResult = null;
        while ((strLine = br.readLine()) != null)
        {
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.equals("["))
                {
                    //return null;
                    break;
                }
                
                String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                
                System.out.println(strLeft + "=" + strRight);
                if (strLeft.equals(strItem))
                {
                    //return strRight;
                    strResult = strRight;
                    break;
                }
            }
        }
        
        br.close();
        return strResult;
    }
    
    boolean deleteItem(String strSector, String strItem) throws IOException
    {
        String strLine = null;
        boolean bFindSector = false;
        boolean bDel = false;
        File tmpFile = File.createTempFile("tmp", "ini", new File("."));
        FileWriter fw = new FileWriter(tmpFile);
        PrintWriter pw = new PrintWriter(fw);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        
        String strOld = null;
        while ((strLine = br.readLine()) != null)
        {
            strOld = strLine;
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.equals("["))
                {
                    bFindSector = false;
                }
                
                String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                
                if (strLeft.equals(strItem))
                {
                    bDel = true;
                    continue;
                }
            }
            
            //fw.write(strOld + "\r\n");
            pw.println(strOld);
        }

        br.close();
        fw.close();
        pw.close();
        
        File file = new File(fileName);
        file.delete();
        tmpFile.renameTo(new File(fileName));
        
        return bDel;
    }

    boolean addItem(String strSector, String strItem, String strVal) throws IOException
    {
        if (null == strSector || null == strItem || strVal == null)
        {
            return false;
        }
        
        String strLine = null;
        boolean bFindSector = false;
        boolean bAdd = false;
        
        File tmpFile = File.createTempFile("tmp", "ini", new File("."));
        tmpFile.deleteOnExit();
        //FileWriter fw = new FileWriter(tmpFile);
        PrintWriter pw = new PrintWriter(tmpFile);
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String strOld = null;
        while ((strLine = br.readLine()) != null)
        {
            strOld = strLine;
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.startsWith("["))
                {
                    bFindSector = false;
                    if (!bAdd)
                    {
                        bAdd = true;
                        pw.println(strItem + " = " + strVal);
                    }
                }
                
                int pos = strLine.indexOf("=");
                if (pos > 1)
                {
                    String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                    String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                    
                    if (strLeft.equals(strItem))
                    {
                        bAdd = true;
                        pw.println(strItem + " = " + strVal);
                        continue;
                    }
                }

            }
            
            //fw.write(strOld + "\r\n");
            pw.println(strOld);
        }

        if (!bAdd)
        {
            pw.println("[" + strSector + "]");
            pw.println(strItem + " = " + strVal);
        }
        
        br.close();
        //fw.close();
        pw.close();
        
        File file = new File(fileName);
        file.delete();
        tmpFile.renameTo(new File(fileName));
        
        return true;
    }

    boolean addItem2(String strSector, String strItem, String strVal) throws IOException
    {
        if (null == strSector || null == strItem || strVal == null)
        {
            return false;
        }
        
        String strLine = null;
        boolean bFindSector = false;
        boolean bAdd = false;
        
        //File tmpFile = File.createTempFile("tmp", "ini", new File("."));
        //tmpFile.deleteOnExit();
        //FileWriter fw = new FileWriter(tmpFile);
        //PrintWriter pw = new PrintWriter(tmpFile);
        StringWriter sw = new StringWriter();
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String strOld = null;
        while ((strLine = br.readLine()) != null)
        {
            strOld = strLine;
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.startsWith("["))
                {
                    bFindSector = false;
                    if (!bAdd)
                    {
                        bAdd = true;
                       // pw.println(strItem + " = " + strVal);
                        sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
                    }
                }
                
                int pos = strLine.indexOf("=");
                if (pos > 1)
                {
                    String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                    String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                    
                    if (strLeft.equals(strItem))
                    {
                        bAdd = true;
                        //pw.println(strItem + " = " + strVal);
                        sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
                        continue;
                    }
                }

            }
            
            //fw.write(strOld + "\r\n");
            //pw.println(strOld);
            sw.write(strOld + System.getProperty("line.separator"));
        }

        if (!bAdd)
        {
            //pw.println("[" + strSector + "]");
            //pw.println(strItem + " = " + strVal);
            sw.write("[" + strSector + "]" + System.getProperty("line.separator"));
            sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
        }
        
        br.close();
        //fw.close();
        //pw.close();
        sw.close();
        
        File file = new File(fileName);
        //file.delete();
        //tmpFile.renameTo(new File(fileName));
        FileWriter fw = new FileWriter(file);
        fw.write(sw.toString());
        fw.close();
        
        return true;
    }    
    
    boolean addItem3(String strSector, String strItem, String strVal) throws IOException
    {
        if (null == strSector || null == strItem || strVal == null)
        {
            return false;
        }
        
        String strLine = null;
        boolean bFindSector = false;
        boolean bAdd = false;
        
        //File tmpFile = File.createTempFile("tmp", "ini", new File("."));
        //tmpFile.deleteOnExit();
        //FileWriter fw = new FileWriter(tmpFile);
        //PrintWriter pw = new PrintWriter(tmpFile);
        //StringWriter sw = new StringWriter();
        ArrayList<String> listLines = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String strOld = null;
        while ((strLine = br.readLine()) != null)
        {
            strOld = strLine;
            strLine = strLine.trim();
            if (strLine.equals("[" + strSector + "]"))
            {
                bFindSector = true;
            }   
            else if (bFindSector)
            {
                if (strLine.startsWith("["))
                {
                    bFindSector = false;
                    if (!bAdd)
                    {
                        bAdd = true;
                       // pw.println(strItem + " = " + strVal);
                        //sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
                        listLines.add(strItem + " = " + strVal);
                    }
                }
                
                int pos = strLine.indexOf("=");
                if (pos > 1)
                {
                    String strLeft = strLine.substring(0, strLine.indexOf("=") - 1).trim();
                    String strRight = strLine.substring(strLine.indexOf("=") + 1).trim();
                    
                    if (strLeft.equals(strItem))
                    {
                        bAdd = true;
                        //pw.println(strItem + " = " + strVal);
                        //sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
                        listLines.add(strItem + " = " + strVal);
                        continue;
                    }
                }

            }
            
            //fw.write(strOld + "\r\n");
            //pw.println(strOld);
            //sw.write(strOld + System.getProperty("line.separator"));
            listLines.add(strOld);
        }

        if (!bAdd)
        {
            //pw.println("[" + strSector + "]");
            //pw.println(strItem + " = " + strVal);
            //sw.write("[" + strSector + "]" + System.getProperty("line.separator"));
            //sw.write(strItem + " = " + strVal + System.getProperty("line.separator"));
            listLines.add("[" + strSector + "]");
            listLines.add(strItem + " = " + strVal);
        }
        
        br.close();
        //fw.close();
        //pw.close();
        //sw.close();
        
        File file = new File(fileName);
        //file.delete();
        //tmpFile.renameTo(new File(fileName));
        FileWriter fw = new FileWriter(file);
        //fw.write(sw.toString());
        for (String strLineItem : listLines)
        {
            fw.write(strLineItem + System.getProperty("line.separator"));
        }
        fw.close();
        
        return true;
    }    
    
}

