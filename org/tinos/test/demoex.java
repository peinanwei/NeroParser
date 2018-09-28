package org.tinos.test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.tinos.engine.Analyzer;
import org.tinos.engine.imp.BinaryForestAnalyzerImp;
import timeProcessor.TimeCheck;
public class demoex{
	public static void main(String args[]) throws IOException{
		Analyzer analyzer = new BinaryForestAnalyzerImp() ;
		analyzer.init();
		//返回分词数据集合
		List<String> sets = new ArrayList<String>();
		TimeCheck tc = new TimeCheck();
		String ss = "从容易开始能从容不迫如果从容易开始于是从容不迫天下等于是非常识时务必为俊杰沿海南方向逃跑他说的确实在理结婚的和尚未结婚的提高产品质量中外科学名著内科学是临床医学的基础 内科学作为临床医学的基础学科，重点论述人体各个系统各种疾病的病因、发病机制、临床表现、诊断、治疗与预防" + 
				""; //大概10字
		//System.out.print("输入：" + ss);
		System.out.println("");
		System.out.println("计时开始");
		tc.begin();
		for(int i = 0; i < 1; i++) {//重复执行 100万次 相当于1000 万字分词
			sets = analyzer.parserString(ss); 
		}
		tc.end();;
		System.out.println("计时结束");
		tc.duration();
		System.out.println("分词效果如下");
		int j=0;
		for(int i = 0; i < sets.size(); i++){
			System.out.print(sets.get(i)+"  |  ");
			j++;
			if(j>15) {//每行15个词语输出
				j=0;
				System.out.println("");
			}
		}
	}
}