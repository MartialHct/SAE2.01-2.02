import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotTest {
protected Robot hp1;
protected Robot hp2;
protected Robot hp3;
protected Entrepot e1;
protected Entrepot e2;
protected Entrepot e3;
protected Entrepot e4;
protected Robot hp4;
protected Robot hp5;
	
	@BeforeEach
	void setUp() throws Exception {
		hp1=new Robot(true,1,4,5);
		hp2=new Robot(false,1,4,5);
		hp3=new Robot(true,1,4,7);
		hp4=new Robot(false,1,4,7);
		hp5=new Robot(true,1,3,7);
		e1=new Entrepot(true,1,3,7);
		e2=new Entrepot(false,1,3,7);
		e3=new Entrepot(false,1,4,7);
		e4=new Entrepot(true,1,4,3);
		}
	
	@Test
	void testdes1() {
		assertThrows(Exception.class,()->{hp1.destocker(e2);});
		}

	@Test
		void testdes2() {
		assertThrows(Exception.class,()->{hp1.destocker(e1);});
			}
	
	@Test
	void testdes3() {
		assertThrows(Exception.class,()->{hp1.destocker(e3);});
		}
	@Test
	void testdes4() {
		assertThrows(Exception.class,()->{hp3.destocker(e4);});
		}
	@Test
	void testdes5() {
		assertThrows(Exception.class,()->{hp3.destocker(e2);});
		}
	@Test
	void testdes6() {
		assertThrows(Exception.class,()->{hp3.destocker(e1);});
		}
	@Test
	void testdes7() {
		assertThrows(Exception.class,()->{hp5.destocker(e2);});
		}
	@Test
	void testdes8() {
		hp5.destocker(e1);
		assertEquals(5,e1.getStock());
		assertEquals(0,hp5.getStockActuel());
		}
	}

