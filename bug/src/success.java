import java.io.File;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;


public class success {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RConnection re = new RConnection(); //开始独占工作空间
   	 
    	double[] xx = {1,2,3}; //生成两个二维数组
    	double[] yy = {4,5,9};
    	 
    	File tempFile = null;
    	re.assign("x", xx); //给R的变量赋值
        re.assign("y", yy);
        
        tempFile = File.createTempFile("test-", ".jpg"); //把图像生成到文件
        String filePath = tempFile.getAbsolutePath();
        
        System.out.println(filePath);
     //   logger.info("Plot file to be produced:" + filePath);
        re.eval("jpeg('D:/try.jpg')");
        REXP p=re.eval("print(GGally::ggpairs(as.data.frame(rbind(c(1,2,3),c(3,6,9),c(2,4,6)))))");
        //System.out.println(p.as);//绘图
        re.eval("dev.off()");
        re.close();
	}

}
