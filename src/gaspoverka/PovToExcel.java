package gaspoverka;

import gaspoverka.poverka.Poverka;
import gaspoverka.poverka.PoverkaPoint;
import gaspoverka.util.Config;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import jxl.CellType;
import jxl.write.Label;
import jxl.Workbook;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

public class PovToExcel {

    memDB db = memDB.getInstance();
    private static final String template_file = ".//xls/pov.xls";
    String out_file = ".//";
    private static Workbook template;
    private static WritableWorkbook wb;
    Config config = Config.getInstance();
    Poverka pov;
    File out;

    public PovToExcel(Poverka pov) {
        this.pov = pov;
    }

    private boolean open() {
        try {
            if (config.getConfig().getProperty("out-dir") != null) {
                out_file = config.getConfig().getProperty("out-dir");
            }
            out_file = out_file + pov.getDevNum()
                    + "-"
                    + formOwner(pov.getOwner())
                    + "-"
                    + pov.getNow().toString()
                    + ".xls";
            out = new File(out_file);
            template = Workbook.getWorkbook(new File(template_file));
            wb = Workbook.createWorkbook(out, template);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public void populate() {
        try {
            if (open() && pov != null) {
                fill();
                save();
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fill() {
        WritableSheet sh;
        WritableCell cell;
        try {
            sh = wb.getSheet(0);
            if (sh != null) {
                //proto num
                cell = sh.getWritableCell("E6");
                if (cell.getType() == CellType.LABEL) {
                    Label val = (Label) cell;
                    val.setString(String.valueOf(pov.getPovNum()));
                }
                //date
                cell = sh.getWritableCell("H6");
                if (cell.getType() == CellType.LABEL) {
                    Label val = (Label) cell;
                    SimpleDateFormat df = new SimpleDateFormat();
                    df.applyPattern("dd.MM.yyyy");
                    val.setString(df.format(pov.getNow())+" г.");
                }
                //type
                cell = sh.getWritableCell("C8");
                if (cell.getType() == CellType.LABEL) {
                    Label val = (Label) cell;
                    val.setString(pov.getType());
                }
                //Diam
                cell = sh.getWritableCell("F8");
                if (cell.getType() == CellType.LABEL) {
                    Label val = (Label) cell;
                    val.setString(pov.getDiam());
                }
                //Diap
                cell = sh.getWritableCell("H8");
                if (cell.getType() == CellType.LABEL) {
                    Label val = (Label) cell;
                    val.setString(pov.getDiap());
                }

                //dev num
                cell = sh.getWritableCell("C9");
                if (cell.getType() == CellType.LABEL) {
                    Label val = (Label) cell;
                    val.setString(pov.getDevNum());
                }
                //owner
                cell = sh.getWritableCell("C10");
                if (cell.getType() == CellType.LABEL) {
                    Label val = (Label) cell;
                    val.setString(pov.getOwner());
                }
                //executor
                cell = sh.getWritableCell("D47");
                if (cell.getType() == CellType.LABEL) {
                    Label val = (Label) cell;
                    val.setString(pov.getExec());
                }

                //Tenv
                cell = sh.getWritableCell("C17");
                if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(pov.getTenv());
                }

                //Penv
                cell = sh.getWritableCell("C18");
                if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(pov.getPenv());
                }
                
                for (int i = 0; i < pov.getData().size(); i++) {
                    PoverkaPoint point = pov.getData().get(i);
                    //G - refrence
                    cell = sh.getWritableCell("B"+getRow(point));
                    if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(point.getRG());
                    }
                    //P
                   cell = sh.getWritableCell("C"+getRow(point));
                    if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(point.getRP());
                    }
                    //T
                    cell = sh.getWritableCell("D"+getRow(point));
                    if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(point.getRT());
                    }
                    //V
                   cell = sh.getWritableCell("E"+getRow(point));
                    if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(point.getRV());
                    }
                     //G - counter
                    cell = sh.getWritableCell("F"+getRow(point));
                    if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(point.getCG());
                    }
                    //P
                    cell = sh.getWritableCell("G"+getRow(point));
                    if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(point.getCP());
                    }
                    //T
                    cell = sh.getWritableCell("H"+getRow(point));
                    if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(point.getCT());
                    }
                    //V
                    cell = sh.getWritableCell("I"+getRow(point));
                    if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        val.setValue(point.getCV());
                    }
                    //err
                    cell = sh.getWritableCell("J"+getRow(point));
                    if (cell.getType() == CellType.NUMBER) {
                        Number val = (Number) cell;
                        if (pov.getIsDeltaT() == false)
                        {
                            val.setValue(point.getErr());
                        } else
                        {
                            val.setValue(point.getErrT());
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try {
            wb.write();
            wb.close();
            JOptionPane.showMessageDialog(null, "Отчет записан в " + out.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getRow(PoverkaPoint point) {
        return String.valueOf(27 + point.getMeasureNum() - 1);
    }

    private String formOwner(String owner) {
        String str = new String();
        for (int i = 0; i < owner.length(); i++) {
            if (owner.charAt(i) == '"') {
                str = str + "";
            } else {
                str = str + String.valueOf(owner.charAt(i));
            }

        }
        return str;
    }
}
