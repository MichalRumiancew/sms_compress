
package Compress;

        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.Assert.*;

public class NaiveCompressImplTest {

    private NaiveCompressImpl compressor;


    @Test
    public void compress() {
        String given = "Ala ma kota";
        String expected = "AlaMaKota";
        assertEquals(expected, compressor.compress(given));
    }

    @Test
    public void uncompress() {
        String given = "AlaMaKota";
        String expected = "ala ma kota";
        assertEquals(expected, compressor.uncompress(given));

    }

    @Test
    public void compressEmpty() {
        String given = "";
        String expected = "";
        assertEquals(expected, compressor.uncompress(given));
    }

    @Test
    public void compressMixedCase() {
        String given = "AlA MA KoTa";
        String expected = "AlaMaKota";
        assertEquals(expected, compressor.compress(given));
    }

    @Test
    public void uncompressEmpty() {
        String given = "";
        String expected = "";
        assertEquals(expected, compressor.uncompress(given));
    }

    @Before
    public void setUp() throws Exception {
        compressor = new NaiveCompressImpl();
    }
}