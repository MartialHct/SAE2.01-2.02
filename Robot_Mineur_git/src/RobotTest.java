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
		protected MondeV2 m1;
		protected MondeV2 m2;
		protected MondeV2 m3;
		protected MondeV2 m4;
		protected MondeV2 m5;
		    @BeforeEach
		    void setUp() throws Exception {
		        hp1=new Robot(true,1,0,5);
		        hp2=new Robot(true,1,5,5);
		        hp3=new Robot(true,1,9,5);
		        hp4=new Robot(true,1,5,0);
		        hp5=new Robot(true,1,5,9);
		        ////
		        
		        ///
		        e4=new PointEau(4,5);
		        e5=new PointEau(6,5);
		        e6=new PointEau(5,4);
		        e7=new PointEau(5,6);
		        Robot r1,r2,r3,r4,r5,r6,r7;
		        r4=new Robot(true,1,4,5);
		        r5=new Robot(true,4,6,5);
		        r6=new Robot(false,6,5,4);
		        r7=new Robot(false,7,5,6);
		        r1=new Robot(true,1,0,6);
		        r2=new Robot(true,4,0,4);
		        r3=new Robot(false,6,1,5);
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
		        Robot[] triangle6=new Robot[] {r4,r5,r6,r7};
		        Robot[] triangle7=new Robot[] {r1,r2,r3};
		        m1=new MondeV2(triangle4,triangle7);
		        m2=new MondeV2(triangle2,triangle6);
		        m3=new MondeV2(triangl3,triangle6);
		        m4=new MondeV2(triangle4,triangle6);
		        m5=new MondeV2(triangle5,triangle6);
		        }

		    @Test
		    void testdepl1() {
		        assertThrows(Exception.class,()->{hp1.deplacerV2("H",m5);});
		        }
		    @Test
		    void testdepl2() {
		        assertThrows(Exception.class,()->{hp2.deplacerV2("yy",m2);});
		        }
		    @Test
		    void testdepl3() {
		    	assertThrows(Exception.class,()->{hp1.deplacerV2("yy",m2);});
		        }

		    @Test
		        void testdepl4() {
		            hp2.deplacerV2("H",m1);
		            assertEquals(4,hp2.getX());
		            }
		    @Test
		    void testdepl5() {
		        assertThrows(Exception.class,()->{hp3.deplacerV2("B",m3);});
		        }
		    @Test
		    void testdepl6() {
		        assertThrows(Exception.class,()->{hp2.deplacerV2("G",m2);});
		        }
		    @Test
		    void testdepl7() {
		        assertThrows(Exception.class,()->{hp3.deplacerV2("autre",m1);});
		        }
		    @Test
		    void testdepl8() {
		    	hp2.deplacerV2("B",m1);
	            assertEquals(6,hp2.getX());		        }
		    @Test
		    void testdepl9() {
		        assertThrows(Exception.class,()->{hp5.deplacerV2("D",m5);});
		        }
		    @Test
		    void testdepl10() {
		        assertThrows(Exception.class,()->{hp2.deplacerV2("au",m2);});
		        }

		    @Test
		    void testdepl11() {
		        assertThrows(Exception.class,()->{hp5.deplacerV2("au",m2);});
		        }
		    @Test
		    void testdepl12() {
		        hp2.deplacerV2("D",m1);
		        assertEquals(6,hp2.getY());
		        }
		    
		    @Test
		    void testdepl13() {
		        assertThrows(Exception.class,()->{hp4.deplacerV2("G",m4);});
		        }
		    @Test
		    void testdepl14() {
		        assertThrows(Exception.class,()->{hp2.deplacerV2("H",m2);});
		        }
		    @Test
		    void testdepl15() {
		        assertThrows(Exception.class,()->{hp4.deplacerV2("au",m2);});
		        }
		    @Test
		    void testdepl16() {
		        hp2.deplacerV2("G",m1);
		        assertEquals(4,hp2.getY());
		        }
}
		    

