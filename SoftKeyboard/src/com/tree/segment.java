package com.tree;

import java.util.HashMap;
import java.util.Map;

public class segment {
	
	 static treenodes[] py = new treenodes[26] ;
	 static String[] py_table = {"ai;an;ang;ao","ba;bai;ban;bang;bao;be;bei;ben;beng;bi;bia;bian;biao;bie;bin;bing;bo;bu"
		 ,"ca;cai;can;cang;cao;ce;cen;ceng;cha;chai;chan;;chang;chao;che;chen;cheng;chi;chong;chou;chu;chua;chuai;chuan;chuang;chui;chun;chuo;ci;;cong;cou;cu;cuan;cui;cun;cuo;"
		 ,"da;dai;dan;dang;dao;de;dei;den;deng;di;dia;dian;diao;die;ding;diu;dong;dou;du;duan;dui;dun;;duo","en;eng;er"
		 ,"fa;fan;fang;fei;fen;feng;fiao;fo;fou;fu","ga;gai;gan;gang;gao;ge;gei;gen;geng;gong;gou;gu;gua;guai;guan;guang;gui;gun;guo"
		 ,"ha;hai;han;hang;hao;he;hei;hen;heng;hong;hou;hu;hua;huai;huan;huang;hui;hun;huo","i","ji;jia;jian;jiang;jiao;jie;jin;jing;jiong;jiu;ju;juan;jue;jun"
		 ,"ka;kai;kan;kang;kao;ke;kei;ken;keng;kong;kou;ku;kua;kuai;kuan;kuang;kui;kun;kuo","la;lai;lan;lang;lao;le;lei;leng;li;lia;lian;liang;liao;lie;lin;ling;liu;lo;long;lou;lu;lv;luan;lue;lun;luo"
		 ,"ma;mai;man;mang;mao;me;mei;men;meng;mi;mian;miao;mie;min;ming;miu;mo;mou;mu","na;nai;nan;nang;nao;ne;nei;nen;neng;ni;nian;niang;niao;nie;nin;ning;niu;nong;nou;nu;nuan;nue;nun;nv;nve;nuo"
		 ,"ou","pa;pai;pan;pang;pao;pei;pen;peng;pi;pian;piao;pie;pin;ping;po;pou;pu","qi;qia;qian;qiang;qiao;qie;qin;qing;qiong;qiu;qu;quan;que;qun","ran;rang;rao;re;ren;reng;ri;rong;rou;ru;rua;ruan;rui;run;ruo"
		 ,"sa;sai;san;sang;sao;se;sen;seng;sha;shai;shan;shang;shao;she;shen;sheng;shi;shou;shu;shua;shuai;shuan;shuang;shui;shun;shuo;si;song;sou;su;suan;sui;sun;suo"
		 ,"ta;tai;tan;tang;tao;te;teng;ti;tian;tiao;tie;ting;tong;tou;tu;tuan;tui;tun;tuo","u","v","wa;wai;wan;wang;wei;wen;weng;wo;wu","xi;xia;xian;xiang;xiao;xie;xin;xing;xiong;xiu;xu;xuan;xue;xun"
		 ,"ya;yan;yang;yao;ye;yi;yin;ying;yo;yong;you;yu;yuan;yue;yun"
		 ,"za;zai;zan;zang;zao;ze;zei;zen;zeng;zha;zhai;zhan;zhang;zhao;zhe;zhen;zheng;zhi;zhong;zhou;zhu;zhua;zhuai;zhuan;zhuang;zhui;zhun;zhuo;zi;zong;zou;zu;zuan;zui;zun;zuo"};
 public static void main(String[] args)
	 {
	//	 System.out.print(seg("huangshaohan"));		
		 String t = seg("hshaohan");
		 String[] te = t.split("'");
		 String[] temp = null;
		 for(int i = 0; i < te.length ;i++)
		 { 
		        if(makeHashSet(te[i])!=null)
		        {	
		        	temp = makeHashSet(te[i]);
		        	for(int j = 0; j<temp.length;j++)
		        	{
		        		System.out.println(temp[j]);
		        	}
		        }
		        else 
		        	System.out.println(te[i]);
		 }
	 }
	 public static String seg(String input)
	 {
		 String[] t = input.split("'");
		 //String out = null;		 
		 int ll_index = 0;
		 String output = null;
		 for(int i = 0;i<t.length;i++)
		 {
	//		 StringBuffer sb  = new StringBuffer(t[]);
			 char[] char_temp = t[i].toCharArray();
			 int l = 0;
			 int[] ll = new int[20];
			 ll_index = 0;
			 while(l < char_temp.length)
			 {
				 int pingyin_index = char_temp[l] - 97;
				 treenodes temp = new treenodes(String.valueOf(char_temp[l]));
				 temp.adddata(py_table[pingyin_index]);
				 char[] char_spilt = String.valueOf(char_temp).substring(l).toCharArray();
				 l = l + temp.matchmax(char_spilt);
				// System.out.println(l);
				 ll[ll_index++] = l;
			 }
			 ll_index = 0;
			 char[] input_t = new char[100];
			 int j = 0;
			 for(int n = 0;n<char_temp.length;n++)
			 {
				 if(n == ll[ll_index])
				 {
					 ll_index++;
					 input_t[j++] = '\'';
				 }
				 input_t[j++] = char_temp[n];			 
			 }
			 input_t[j] = '\0';
			// System.out.println(String.valueOf(input_t, 0, j)+"3412");
			 if(output==null)
				 output = String.valueOf(input_t, 0, j) + "'";
			 else
				 output  = output + String.valueOf(input_t, 0, j) + "'";
		 }
		 return output;
	 } 
	 /*
	 private static void displaytree(treenodes f) {       //�ݹ���ʾ��  
         
         String preStr = "";  
     
         for(int i=0; i<f.childlist.size(); i++) {  
             treenodes t = f.childlist.get(i);  
             System.out.println(preStr + "-"+t.data);  
            
          if(! t.childlist.isEmpty()) {  
              displaytree(t);  
          }  
         }  
    }
	 */
		public static String[] makeHashSet(String a)
		{
			 Map<String, String[]> map=new HashMap<String, String[]>();
			 String[] b_i = "ba;bai;ban;bang;bao;be;bei;ben;beng;bi;bian;biao;bie;bin;bing;bo;bu".split(";");
			 map.put("b", b_i);
			 String[] c_i = "ca;cai;can;cang;cao;ce;cen;ceng;ci;;cong;cou;cu;cuan;cui;cun;cuo;".split(";");
			 map.put("c", c_i);
			 String[] ch_i = "cha;chan;;chang;chao;che;chen;cheng;chi;chong;chou;chu;chuan;chuang;chui;chun;chuo;".split(";");
			 map.put("ch", ch_i);
			 String[] d_i = "da;dai;dan;dang;dao;de;deng;di;dia;dian;diao;die;ding;diu;dong;dou;du;duan;dui;dun;;duo".split(";");
			 map.put("d", d_i);
			 String[] f_i = "fa;fan;fang;fei;fen;feng;fiao;fo;fou;fu".split(";");
			 map.put("f", f_i);
			 String[] g_i = "ga;gai;gan;gang;gao;ge;gei;gen;geng;gong;gou;gu;gua;guai;guan;guang;gui;gun;guo".split(";");
			 map.put("g", g_i);
			 String[] h_i = "ha;hai;han;hang;hao;he;hen;heng;hong;hou;hu;hua;huan;huang;hui;hun;huo".split(";");
			 map.put("h", h_i);
			 String[] j_i = "ji;jia;jian;jiang;jiao;jie;jin;jing;jiong;jiu;ju;juan;jue;jun".split(";");
			 map.put("j", j_i);
			 String[] k_i = "ka;kai;kan;kang;kao;ke;ken;keng;kong;kou;ku;kua;kuai;kuan;kuang;kui;kun;kuo".split(";");
			 map.put("k", k_i);
			 String[] l_i = "la;lai;lan;lang;lao;le;lei;leng;li;lia;lian;liang;liao;lie;lin;ling;liu;long;lou;lu;lv;luan;lue;luo".split(";");
			 map.put("l", l_i);
			 String[] m_i = "ma;mai;man;mang;mao;me;mei;men;meng;mi;mian;miao;mie;min;ming;miu;mo;mou;mu".split(";");
			 map.put("m", m_i);
			 String[] n_i = "na;nai;nan;nang;nao;ne;nei;ni;nian;niang;niao;nie;nin;ning;niu;nong;nou;nu;nv;nuo".split(";") ;
			 map.put("n", n_i);
			 String[] p_i = "pa;pai;pan;pang;pao;pei;pen;peng;pi;pian;piao;pie;pin;ping;po;pou;pu".split(";");
			 map.put("p", p_i);
			 String[] q_i = "qi;qian;qiang;qiao;qie;qin;qing;qiong;qiu;qu;quan;que;qun".split(";");
			 map.put("q", q_i);
			 String[] r_i = "ran;rang;rao;re;ren;reng;rong;rou;ru;ruan;rui;run;ruo".split(";");
			 map.put("r", r_i);
			 String[] s_i = "sa;sai;san;sang;se;sen;seng;si;song;sou;su;suan;sui;sun;suo".split(";");
			 map.put("s", s_i);
			 String[] sh_i = "sha;shai;shan;shang;shao;she;shen;sheng;shi;shou;shu;shua;shuai;shuan;shuang;shui;shuo;".split(";") ;
			 map.put("sh", sh_i);
			 String[] t_i = "ta;tai;tan;tang;tao;te;teng;ti;tian;tiao;tie;ting;tong;tou;tu;tuan;tui;tun;tuo".split(";");
			 map.put("t", t_i);
			 String[] w_i = "wa;wai;wan;wang;wei;wen;weng;wo;wu".split(";");
			 map.put("w", w_i);
			 String[] x_i = "xi;xia;xian;xiang;xiao;xie;xin;xing;xiong;xiu;xu;xuan;xue;xun".split(";");
			 map.put("x", x_i);
			 String[] y_i = "ya;yan;yang;yao;ye;yi;yin;ying;yo;yong;you;yu;yuan;yue;yun".split(";");
			 map.put("y", y_i);
			 String[] z_i = "za;zai;zan;zang;zao;ze;zen;zeng;zi;zong;zou;zu;zuan;zui;zun;zuo".split(";");
			 map.put("z", z_i);
			 String[] zh_i = "zha;zhai;zhan;zhang;zhao;zhe;zhen;zheng;zhi;zhong;zhou;zhu;zhua;zhuai;zhuan;zhuang;zhui;zhun;zhuo;".split(";");
			 map.put("zh", zh_i);
			if(! map.containsKey(a))
				return null;
			String[] temp = (String[]) map.get(a);
			return temp ;
		}
}
