package apractice.practice03;

import org.junit.*;

public class P02_JUnit {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass");
        // Her class'da ilk calisir,1 kere calisir.
    }

    @Before
    public void before() {
        System.out.println("Before");
        //her testten once calisir.
    }

    @After
    public void after() {
        System.out.println("After");
        //Her testten sonra calisir.
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        System.out.println("AfterClass");
        //
    }

    @Test
    public void test01() {
        System.out.println("test 01");

    }

    @Test
    public void test02() {
        System.out.println("test 02");

    }

    @Test
    public void test03() {
        System.out.println("test 03");

    }


}
