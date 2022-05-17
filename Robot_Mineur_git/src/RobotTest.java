import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotTest {
		protected Robot hp1;
		protected Robot hp2;
		protected Robot hp3;
		protected Robot hp4;
		protected Robot hp5;
		protected PointEau e3;
		protected PointEau e2;
		protected PointEau e1;
		protected PointEau e4;
		protected PointEau e5;
		protected PointEau e10;
		protected PointEau e6;
		protected PointEau e7;
		protected PointEau e8;
		protected PointEau e9;
		protected PointEau e11;
		protected PointEau e12;
		protected PointEau e13;
		protected PointEau e14;
		protected PointEau e15;
		protected PointEau e16;
		protected Monde m1;
		protected Monde m2;
		protected Monde m3;
		protected Monde m4;
		protected Monde m5;

		    @BeforeEach
		    void setUp() throws Exception {
		        hp1=new Robot(true,1,0,5);
		        hp2=new Robot(true,1,5,5);
		        hp3=new Robot(true,1,9,5);
		        hp4=new Robot(true,1,5,0);
		        hp5=new Robot(true,1,5,9);
		        e1=new PointEau(1,5);
		        e2=new PointEau(0,6);
		        e3=new PointEau(0,4);
		    	PointEau[] triangle=new PointEau[] {e1,e2,e3};
		        ///
		        e4=new PointEau(4,5);
		        e5=new PointEau(6,5);
		        e6=new PointEau(5,4);
		        e7=new PointEau(5,6);
		        /////
		        e8=new PointEau(8,5);
		        e9=new PointEau(9,6);
		        e10=new PointEau(9,4);
		        /////
		        e11=new PointEau(5,1);
		        e12=new PointEau(4,0);
		        e13=new PointEau(6,0);
		       
		        /////
		        e14=new PointEau(5,8);
		        e15=new PointEau(4,9);
		        e16=new PointEau(6,9);
		        PointEau[] triangle2=new PointEau[] {e4,e5,e6,e7};
		        PointEau[] triangl3=new PointEau[] {e8,e9,e10};
		        PointEau[] triangle4=new PointEau[] {e11,e12,e13};
		        PointEau[] triangle5=new PointEau[] {e14,e15,e16};
		        m1=new Monde(triangle);
		        m2=new Monde(triangle2);
		        m3=new Monde(triangl3);
		        m4=new Monde(triangle4);
		        m5=new Monde(triangle5);
		        }

		    @Test
		    void testdepl1() {
		        assertThrows(Exception.class,()->{hp1.deplacer("H",m1);});
		        }
		    @Test
		    void testdepl2() {
		        assertThrows(Exception.class,()->{hp2.deplacer("yy",m2);});
		        }
		    @Test
		    void testdepl3() {
		    	assertThrows(Exception.class,()->{hp1.deplacer("yy",m2);});
		        }

		    @Test
		        void testdepl4() {
		            hp2.deplacer("H",m1);
		            assertEquals(4,hp2.getX());
		            }
		    @Test
		    void testdepl5() {
		        assertThrows(Exception.class,()->{hp3.deplacer("B",m3);});
		        }
		    @Test
		    void testdepl6() {
		        assertThrows(Exception.class,()->{hp2.deplacer("G",m2);});
		        }
		    @Test
		    void testdepl7() {
		        assertThrows(Exception.class,()->{hp3.deplacer("autre",m1);});
		        }
		    @Test
		    void testdepl8() {
		    	hp2.deplacer("B",m1);
	            assertEquals(6,hp2.getX());		        }
		    @Test
		    void testdepl9() {
		        assertThrows(Exception.class,()->{hp5.deplacer("D",m5);});
		        }
		    @Test
		    void testdepl10() {
		        assertThrows(Exception.class,()->{hp2.deplacer("au",m2);});
		        }

		    @Test
		    void testdepl11() {
		        assertThrows(Exception.class,()->{hp5.deplacer("au",m2);});
		        }
		    @Test
		    void testdepl12() {
		        hp2.deplacer("D",m1);
		        assertEquals(6,hp2.getY());
		        }
		    
		    @Test
		    void testdepl13() {
		        assertThrows(Exception.class,()->{hp4.deplacer("G",m4);});
		        }
		    @Test
		    void testdepl14() {
		        assertThrows(Exception.class,()->{hp2.deplacer("H",m2);});
		        }
		    @Test
		    void testdepl15() {
		        assertThrows(Exception.class,()->{hp4.deplacer("au",m2);});
		        }
		    @Test
		    void testdepl16() {
		        hp2.deplacer("G",m1);
		        assertEquals(4,hp2.getY());
		        }
}
		    

