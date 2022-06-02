package id.co.backend.tester;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

public class PdfGenerator {

    static String page1 ="<html><head>\n" +
            "  <style>\n" +
            ".border-page {  \n" +
            "  margin: 40px 50px 70px;\n" +
            "padding: 5px 3px;\n" +
            "border-color: black;\n" +
            "border-width: 3.5px;\n" +
            "border-style: double;\n" +
            "}\n" +
            ".border-page .inside-border{\n" +
            "  margin: 4px;\n" +
            "padding: 5px 3px;\n" +
            "border-color: black;\n" +
            "border-width: 1.4px;\n" +
            "border-style: inset;\n" +
            "}\n" +
            "\n" +
            "td:nth-child(3){\n" +
            "  width: 140px; \n" +
            "}\n" +
            "\n" +
            "td, th{\n" +
            "text-align: left;\n" +
            "padding-bottom: 2px;\n" +
            "font-size: 9px;\n" +
            "}\n" +
            "\n" +
            ".page1 td.key{\n" +
            "padding-right : 10px;\n" +
            "}\n" +
            ".page1 td.another-key{\n" +
            "padding-left : 30px;\n" +
            "  padding-right : 10px;\n" +
            "}\n" +
            "\n" +
            ".content-page1 .images, .footer{\n" +
            "  margin-left: 13px;\n" +
            "  margin-right: 13px;\n" +
            "  margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".footer-page1{\n" +
            "  position: relative;\n" +
            "    top: -9px;\n" +
            "    margin-left: 13px;\n" +
            "    margin-right: 13px;\n" +
            "}\n" +
            "  </style>\n" +
            "  <link href=\"style.css\" rel=\"stylesheet\">\n" +
            "</head>\n" +
            "<body>\n" +
            "  <div class=\"page-a4\">\n" +
            "  <div class=\"border-page\">\n" +
            "      <div class=\"inside-border\">\n" +
            "        <div class=\"page1\">\n" +
            "          <div class=\"header-page1\" style=\"margin-left: 5px;margin-right: 5px;\n" +
            "position: relative;\">\n" +
            "              <div class=\"left-sider\" style=\"text-align: center; color: white; width: 350px;background: #1F477B;\">\n" +
            "                  <div style=\"font-size: 14px;\n" +
            "                  padding-top: 4px;font-weight: bold;margin-bottom: 6px;\">\n" +
            "                    <u style=\"border-bottom: 3px solid white;text-decoration: none;\">\n" +
            "                      LAPORAN PENILAIAN RINGKAS\n" +
            "                    </u>\n" +
            "                  </div>\n" +
            "                  <div style=\"margin-bottom: 2px;font-size: 9px;font-weight: bold;\">BERITA ACARA PENILAIAN AGUNAN (BAP)</div>\n" +
            "                  <div style=\"font-size: 9px;\n" +
            "  font-weight: bold;padding-bottom: 2px;\">PT. Bank Central Asia, Tbk.</div>\n" +
            "              </div>\n" +
            "              <div class=\"right-sider\" style=\"display: flex;position: absolute;top: 0px;right: 40px;\">\n" +
            "                  <div>\n" +
            "                  <img src=\"https://kjppku.id/wp-content/uploads/2019/02/Logo-KJPP-1.png\" style=\"height: 33px;width: 55px;display: block;\n" +
            "margin-left: auto;\n" +
            "margin-right: auto;\">\n" +
            "                  <a style=\"font-size: 14px;color: black;\">Kjpp Harapan Baru</a>\n" +
            "                  </div>\n" +
            "              </div>\n" +
            "          </div>\n" +
            "\n" +
            "          <div class=\"content-page1\">\n" +
            "              <div class=\"data\">\n" +
            "                  <table class=\"page1\" style=\"margin-top: 29px;margin-left: 10px;\">\n" +
            "                      <tbody><tr>\n" +
            "                        <td class=\"key\">No. Laporan</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>12345678910</td>\n" +
            "                        <td class=\"another-key\"></td>\n" +
            "                        <td></td>\n" +
            "                        <td></td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Tanggal BAP</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>05-04-2022</td>\n" +
            "                        <td class=\"another-key\"></td>\n" +
            "                        <td></td>\n" +
            "                        <td></td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Tanggal Inspeksi</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>05-04-2022</td>\n" +
            "                        <td class=\"another-key\"></td>\n" +
            "                        <td></td>\n" +
            "                        <td></td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Tanggal Penilaian</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>05-04-2022</td>\n" +
            "                        <td class=\"another-key\">Tipe Pinjaman</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Rumah Tinggal</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Cabang</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Bca Wisma Asia </td>\n" +
            "                        <td class=\"another-key\"></td>\n" +
            "                        <td></td>\n" +
            "                        <td></td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Nama Debitur</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>ABCD EFGH </td>\n" +
            "                        <td class=\"another-key\"></td>\n" +
            "                        <td></td>\n" +
            "                        <td></td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Lokasi Jaminan</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Jalan ABCD EFGH no 123 </td>\n" +
            "                        <td class=\"another-key\"></td>\n" +
            "                        <td></td>\n" +
            "                        <td></td>\n" +
            "                      </tr>\n" +
            "                       <tr>\n" +
            "                        <td class=\"key\">Dati II</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Jakarta</td>\n" +
            "                        <td class=\"another-key\">Kelurahan</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Pluit</td>\n" +
            "                      </tr>\n" +
            "                       <tr>\n" +
            "                        <td class=\"key\">Kecamatan</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Penjaringan</td>\n" +
            "                        <td class=\"another-key\">Kode Pos</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>12345</td>\n" +
            "                      </tr>\n" +
            "                    </tbody></table>\n" +
            "              </div>\n" +
            "              <div class=\"images\">\n" +
            "                <div class=\"tampak-depan\" style=\"border: 2px solid black;padding: 5px 4px;margin-bottom: 10px;\">\n" +
            "                  <a style=\"font-size: 9px;color: black;\">Foto Tampak Depan Properti</a>\n" +
            "                  <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 150px;width: 300px;display: block;\n" +
            "                      margin-left: auto; margin-right: auto;\">\n" +
            "                </div>\n" +
            "                <div class=\"tampak-kiri\" style=\"border: 2px solid black;\n" +
            "  padding: 5px 4px;\n" +
            "  margin-bottom: 10px;\">\n" +
            "                  <a style=\"font-size: 9px;color: black;\">Foto Tampak Kiri Properti</a>\n" +
            "                    <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 150px;width: 300px;display: block;\n" +
            "                        margin-left: auto;margin-right: auto;\">\n" +
            "                </div>\n" +
            "                <div class=\"tampak-kanan\" style=\"border: 2px solid black;\n" +
            "  padding: 5px 4px;\n" +
            "  margin-bottom: 10px;\">\n" +
            "                  <a style=\"font-size: 9px;color: black;\">Foto Tampak Kanan Properti</a>\n" +
            "                      <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 150px;width: 300px;display: block;\n" +
            "                        margin-left: auto;margin-right: auto;\">\n" +
            "                </div>\n" +
            "              </div>\n" +
            "          </div>\n" +
            "        <div class=\"footer-page1\">\n" +
            "        <div class=\"data\" style=\"border: 2px solid;\">\n" +
            "          <table class=\"page1\" style=\"margin-left: 10px;\">\n" +
            "              <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"key\">No. LPPA</td>\n" +
            "                <td>:</td>\n" +
            "                <td>12345</td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "            </tbody></table>\n" +
            "       </div>\n" +
            "      \n" +
            "      \n" +
            "      \n" +
            "      \n" +
            "      \n" +
            "      \n" +
            "   \n" +
            "       </div> \n" +
            "        </div>\n" +
            "      </div>\n" +
            "  </div>\n" +
            "  </div>\n" +
            "</body></html>";

    static String page2 = "<html><head>\n" +
            "  <style>\n" +
            ".border-page {  \n" +
            "  margin: 40px 50px 70px;\n" +
            "padding: 5px 3px;\n" +
            "border-color: black;\n" +
            "border-width: 3.5px;\n" +
            "border-style: double;\n" +
            "}\n" +
            ".border-page .inside-border{\n" +
            "  margin: 4px;\n" +
            "border-color: black;\n" +
            "border-width: 1.4px;\n" +
            "border-style: inset;\n" +
            "}\n" +
            "\n" +
            ".footer-page1 td:nth-child(3){\n" +
            "  width: 140px; \n" +
            "}\n" +
            "\n" +
            ".footer-page1 td, .footer-page1 th{\n" +
            "text-align: left;\n" +
            "padding-bottom: 2px;\n" +
            "font-size: 9px;\n" +
            "}\n" +
            "\n" +
            ".table-nilai td, .table-nilai th{\n" +
            "  border-left: 2px solid black;\n" +
            "  border-right: 2px solid black;\n" +
            "}\n" +
            "\n" +
            ".table-nilai th{\n" +
            "  background: #C4BB95;\n" +
            "    border: 2px solid black;\n" +
            "    width: 69.7px;\n" +
            "    font-size: 9px;\n" +
            "    height: 35px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".page1 td.key{\n" +
            "padding-right : 10px;\n" +
            "}\n" +
            ".page1 td.another-key{\n" +
            "padding-left : 30px;\n" +
            "  padding-right : 10px;\n" +
            "}\n" +
            "\n" +
            ".content-page1 .images, .footer{\n" +
            "  margin-left: 13px;\n" +
            "  margin-right: 13px;\n" +
            "  margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".footer-page1{\n" +
            "  position: relative;\n" +
            "    top: -9px;\n" +
            "    margin-left: 13px;\n" +
            "    margin-right: 13px;\n" +
            "}\n" +
            "  </style>\n" +
            "  <link href=\"style.css\" rel=\"stylesheet\">\n" +
            "</head>\n" +
            "<body>\n" +
            "  <div class=\"page-a4\">\n" +
            "  <div class=\"border-page\">\n" +
            "      <div class=\"inside-border\">\n" +
            "        <div class=\"page1\">\n" +
            "          <div class=\"header-page1\" style=\"margin-left: 5px;margin-right: 5px;position: relative;\">\n" +
            "              <div class=\"right-sider\" style=\"display: flex;position: absolute;top: 0px;padding: 2px 4px;right: 40px;\">\n" +
            "                  <div>\n" +
            "                  <img src=\"https://kjppku.id/wp-content/uploads/2019/02/Logo-KJPP-1.png\" style=\"height: 33px;width: 55px;display: block;\n" +
            "margin-left: auto;\n" +
            "margin-right: auto;\">\n" +
            "                  <a style=\"font-size: 14px;color: black;\">Kjpp Harapan Baru</a>\n" +
            "                  </div>\n" +
            "              </div>\n" +
            "          </div>\n" +
            "\n" +
            "          <div class=\"content-page1\" style=\"margin-left: 13px;padding-top: 65px;padding-bottom: 10px;\">\n" +
            "              <div class=\"data\">\n" +
            "                <a class=\"opening\" style=\"color: black; font-size: 9px;\">\n" +
            "                  Sesuai permintaan PT. Bank Central Asia,Tbk. maka kami telah melakukan penilaian aktiva yang berlokasi di\n" +
            "<p style=\"font-weight: 600;\">\n" +
            "Jalan ABCD EFGH no 123,\n" +
            "Kelurahan ABC, Kecamatan ABCD, Kota Jakarta\n" +
            "</p>\n" +
            "Penilaian berdasarkan dokumen Sertipikat dan Izin Mendirikan Bangunan pada lampiran Lembar Permohonan Penilaian\n" +
            "Agunan (LPPA)\n" +
            "<br>\n" +
            "nomor 12345 tanggal 05-04-2022\n" +
            "<br>\n" +
            "Hasil penilaian ini digunakan untuk keperluan PT. Bank Central Asia,Tbk. untuk tujuan penjaminan hutang.\n" +
            "Dasar penilaian yang digunakan adalah Nilai Pasar (Market Value ) dan Indikasi Nilai Likuidasi (Liquidation Value ).\n" +
            "Berdasarkan hasil analisa dan penelitian terhadap faktor-faktor yang ada hubungannya dengan penilaian yang digunakan,\n" +
            "maka kami uraikan hasil penilaian sebagai berikut :\n" +
            "                </a>\n" +
            "              </div>\n" +
            "          </div>\n" +
            "\n" +
            "      <div class=\"original-value\" style=\"color: white;font-size: 9px;margin-bottom: 5px;padding: 2px 13px;background: #1F477B;\">\n" +
            "        <div>\n" +
            "          NILAI PASAR\n" +
            "        </div>\n" +
            "      </div>\n" +
            "\n" +
            "      <div class=\"value-dis\" style=\"margin-bottom: 22px;\">\n" +
            "          <div style=\"font-size: 9px;font-weight: 600;margin-left: 13px;\">BERDASARKAN LEGALITAS</div>\n" +
            "\n" +
            "          <table class=\"table-nilai\" style=\"font-size: 9px;;margin-top: 4px;border-collapse: collapse;margin-left: 13px;\">\n" +
            "              <tbody><tr><th>ASET</th>\n" +
            "              <th>LUAS <br> (m2)</th>\n" +
            "              <th>NILAI PASAR  <br> per m2 (Rp)</th>\n" +
            "              <th style=\"width: 114px;\">BIAYA PENGGANTI BARU <br> (Rp)</th>\n" +
            "              <th>NILAI PASAR <br> (Rp)</th>\n" +
            "              <th>INDIKASI NILAI LIKUIDASI (Rp)</th>\n" +
            "            </tr>\n" +
            "            </tbody><tbody style=\"border: 2px solid black;\">\n" +
            "            <tr>\n" +
            "              <td>Tanah</td>\n" +
            "              <td>93</td>\n" +
            "              <td>Rp 9.600.000</td>\n" +
            "              <td>Rp 892.800.000</td>\n" +
            "              <td>Rp 892.800.000</td>\n" +
            "              <td>Rp 580.320.000</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "              <td>Bangunan</td>\n" +
            "              <td>110</td>\n" +
            "              <td>Rp 3.950.000</td>\n" +
            "              <td>Rp 468.720.000</td>\n" +
            "              <td>Rp 440.820.000</td>\n" +
            "              <td>Rp 242.452.000</td>\n" +
            "            </tr>\n" +
            "            <tr class=\"footer\" style=\"border-top: 2px solid black;border-bottom: 2px solid black;\">\n" +
            "              <td colspan=\"3\" style=\"border-bottom: 2px solid black;border-top: 2px solid black;text-align: end;padding-right: 42px;\">TOTAL</td>\n" +
            "              <td style=\"border-bottom: 2px solid black;border-top: 2px solid black;\">Rp 1.361.520.000</td>\n" +
            "              <td style=\"border-bottom: 2px solid black;border-top: 2px solid black;\">Rp 1.333.620.000</td>\n" +
            "              <td style=\"border-bottom: 2px solid black;border-top: 2px solid black;\">Rp 822.711.000</td>\n" +
            "            </tr>\n" +
            "          </tbody></table>\n" +
            "\n" +
            "          <div style=\"font-size: 9px;font-weight: 600;margin-left: 13px;margin-top: 7px;\">BERDASARKAN FISIK</div>\n" +
            "\n" +
            "          <table class=\"table-nilai\" style=\"font-size: 9px;;margin-top: 4px;border-collapse: collapse;margin-left: 13px;\">\n" +
            "              <tbody><tr><th>ASET</th>\n" +
            "              <th>LUAS <br> (m2)</th>\n" +
            "              <th>NILAI PASAR  <br> per m2 (Rp)</th>\n" +
            "              <th style=\"width: 114px;\">BIAYA PENGGANTI BARU <br> (Rp)</th>\n" +
            "              <th>NILAI PASAR <br> (Rp)</th>\n" +
            "              <th>INDIKASI NILAI LIKUIDASI (Rp)</th>\n" +
            "            </tr>\n" +
            "            </tbody><tbody style=\"border: 2px solid black;\">\n" +
            "            <tr>\n" +
            "              <td>Tanah</td>\n" +
            "              <td>93</td>\n" +
            "              <td>Rp 9.600.000</td>\n" +
            "              <td>Rp 892.800.000</td>\n" +
            "              <td>Rp 892.800.000</td>\n" +
            "              <td>Rp 580.320.000</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "              <td>Bangunan</td>\n" +
            "              <td>110</td>\n" +
            "              <td>Rp 3.950.000</td>\n" +
            "              <td>Rp 468.720.000</td>\n" +
            "              <td>Rp 440.820.000</td>\n" +
            "              <td>Rp 242.452.000</td>\n" +
            "            </tr>\n" +
            "            <tr class=\"footer\" style=\"border-top: 2px solid black;border-bottom: 2px solid black;\">\n" +
            "              <td colspan=\"3\" style=\"border-bottom: 2px solid black;border-top: 2px solid black;text-align: end;padding-right: 42px;\">TOTAL</td>\n" +
            "              <td style=\"border-bottom: 2px solid black;border-top: 2px solid black;\">Rp 1.361.520.000</td>\n" +
            "              <td style=\"border-bottom: 2px solid black;border-top: 2px solid black;\">Rp 1.333.620.000</td>\n" +
            "              <td style=\"border-bottom: 2px solid black;border-top: 2px solid black;\">Rp 822.711.000</td>\n" +
            "            </tr>\n" +
            "          </tbody></table>\n" +
            "\n" +
            "          <div>\n" +
            "            <table class=\"page1\" style=\"font-size: 9px;margin-top: 10px;margin-left: 11px;\">\n" +
            "              <tbody><tr>\n" +
            "                <td class=\"key\">Indikasi nilai pasar bangunan (khusus Ruko)</td>\n" +
            "                <td>:</td>\n" +
            "                <td></td>\n" +
            "                <td class=\"another-key\">KDB</td>\n" +
            "                <td>:</td>\n" +
            "                <td>60%</td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\">Waktu Pemasaran</td>\n" +
            "                <td>:</td>\n" +
            "                <td>6 bulan</td>\n" +
            "                <td class=\"another-key\">KLB</td>\n" +
            "                <td>:</td>\n" +
            "                <td>1,2</td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\">Peruntukan</td>\n" +
            "                <td>:</td>\n" +
            "                <td>Perumahan/Permukiman</td>\n" +
            "                <td class=\"another-key\">Sub Kategori Peruntukan</td>\n" +
            "                <td>:</td>\n" +
            "                <td>-</td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\">Keterangan</td>\n" +
            "                <td>:</td>\n" +
            "                <td></td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "            </tbody></table>\n" +
            "          </div>\n" +
            "\n" +
            "          <div class=\"dialog\" style=\"margin-left: 12px;font-size: 9px;margin-right: 22px;margin-top: 26px;\">\n" +
            "            <i>Hal-hal yang tidak tercantum di dalam laporan ini mengikuti ketentuan yang terdapat pada perjanjian kerjasama (PKS) dan\n" +
            "              merupakan bagian yang tidak terpisahkan.</i>\n" +
            "          </div>\n" +
            "          <div class=\"assigne\" style=\"margin-left: 12px;font-size: 10px;margin-top: 10px;\">\n" +
            "            <i>Jakarta, 05-04-2022</i>\n" +
            "            <br>\n" +
            "            <a style=\"color: black;\">KJPP Rekanan BCA &amp; Rekan</a>\n" +
            "          </div>\n" +
            "          <div class=\"appraiser\">\n" +
            "            <table class=\"page1\" style=\"font-size: 9px;margin-top: 76px;margin-left: 9px;\">\n" +
            "              <tbody><tr>\n" +
            "                <td class=\"key\" style=\"font-size: 17px;width: 190px;\"><a style=\"border-bottom: 2px solid black;color: black;\">GHIJK, MAPPI(Cert)</a></td>\n" +
            "                <td style=\"font-size: 17px;width: 150px;\"><a style=\"border-bottom: 2px solid black;color: black;\">HIJKL</a></td>\n" +
            "                <td style=\"font-size: 17px;width: 150px;\"><a style=\"border-bottom: 2px solid black;color: black;\">ZXCVBN</a></td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\" style=\"font-size: 9px;width: 190px;\">Kualifikasi Penilai : Penilai Publik</td>\n" +
            "                <td style=\"font-size: 9px;width: 150px;\">Reviewer</td>\n" +
            "                <td style=\"font-size: 9px;width: 150px;\">Surveyor/Pelaksana Inspeksi</td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\" style=\"font-size: 9px;width: 190px;\">Ijin Penilai : P-12345</td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\" style=\"font-size: 9px;width: 190px;\">Mappi : 1234567</td>\n" +
            "              </tr>\n" +
            "            </tbody></table>\n" +
            "          </div>\n" +
            "      </div>\n" +
            "\n" +
            "        <div class=\"footer-page1\">\n" +
            "        <div class=\"data\" style=\"border: 2px solid;\">\n" +
            "          <table class=\"page1\" style=\"margin-left: 10px;\">\n" +
            "              <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"key\">No. LPPA</td>\n" +
            "                <td>:</td>\n" +
            "                <td>12345</td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\">No. Laporan</td>\n" +
            "                <td>:</td>\n" +
            "                <td>12345678</td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "            </tbody></table>\n" +
            "       </div>\n" +
            "       </div> \n" +
            "        </div>\n" +
            "      </div>\n" +
            "  </div>\n" +
            "  </div>\n" +
            "</body></html>";

    static String page3 = "<html><head>\n" +
            "  <style>\n" +
            ".border-page {  \n" +
            "  margin: 40px 50px 70px;\n" +
            "padding: 5px 3px;\n" +
            "border-color: black;\n" +
            "border-width: 3.5px;\n" +
            "border-style: double;\n" +
            "}\n" +
            ".border-page .inside-border{\n" +
            "  margin: 4px;\n" +
            "border-color: black;\n" +
            "border-width: 1.4px;\n" +
            "border-style: inset;\n" +
            "}\n" +
            "\n" +
            ".footer-page1 td:nth-child(3){\n" +
            "  width: 140px; \n" +
            "}\n" +
            "\n" +
            ".footer-page1 td, .footer-page1 th{\n" +
            "text-align: left;\n" +
            "padding-bottom: 2px;\n" +
            "font-size: 9px;\n" +
            "}\n" +
            "\n" +
            ".table-nilai td, .table-nilai th{\n" +
            "  border-left: 2px solid black;\n" +
            "  border-right: 2px solid black;\n" +
            "}\n" +
            "\n" +
            ".table-nilai th{\n" +
            "  background: #C4BB95;\n" +
            "    border: 2px solid black;\n" +
            "    width: 69.7px;\n" +
            "    font-size: 9px;\n" +
            "    height: 35px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".page1 td.key{\n" +
            "padding-right : 10px;\n" +
            "}\n" +
            "\n" +
            "\n" +
            ".content-page1 .images, .footer{\n" +
            "  margin-left: 13px;\n" +
            "  margin-right: 13px;\n" +
            "  margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".footer-page1{\n" +
            "  position: relative;\n" +
            "    top: -9px;\n" +
            "    margin-left: 13px;\n" +
            "    margin-right: 13px;\n" +
            "}\n" +
            "  </style>\n" +
            "  <link href=\"style.css\" rel=\"stylesheet\">\n" +
            "</head>\n" +
            "<body>\n" +
            "  <div class=\"page-a4\">\n" +
            "  <div class=\"border-page\">\n" +
            "      <div class=\"inside-border\">\n" +
            "        <div class=\"page1\">\n" +
            "          <div class=\"header-page1\" style=\"margin-left: 5px;margin-right: 5px;position: relative;padding-bottom: 63px;\">\n" +
            "              <div class=\"right-sider\" style=\"display: flex;position: absolute;top: 0px;padding: 2px 4px;right: 40px;\">\n" +
            "                  <div>\n" +
            "                  <img src=\"https://kjppku.id/wp-content/uploads/2019/02/Logo-KJPP-1.png\" style=\"height: 33px;width: 55px;display: block;\n" +
            "margin-left: auto;\n" +
            "margin-right: auto;\">\n" +
            "                  <a style=\"font-size: 14px;color: black;\">Kjpp Harapan Baru</a>\n" +
            "                  </div>\n" +
            "              </div>\n" +
            "          </div>\n" +
            "\n" +
            "      <div class=\"original-value\" style=\"color: white;font-size: 9px;margin-bottom: 5px;padding: 2px 13px;background: #1F477B;\">\n" +
            "        <div>\n" +
            "          FOTO AGUNAN\n" +
            "        </div>\n" +
            "      </div>\n" +
            "\n" +
            "      <div class=\"value-dis\" style=\"margin-bottom: 7px;\">\n" +
            "        <table class=\"\" style=\"margin-left: 10px;margin-right: 12px;border: 2px solid black;\">\n" +
            "          <tbody>\n" +
            "            <tr>\n" +
            "            <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
            "              <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 150px;width: 250px;display: block;\n" +
            "              margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
            "              <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Depan</a>\n" +
            "            </td>\n" +
            "            <td>\n" +
            "              <table class=\"page1\" style=\"font-size: 9px;\">\n" +
            "                <tbody><tr>\n" +
            "                  <td class=\"key\">Bentuk Bangunan</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td> Bertingkat 1 (2 Lantai)</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Basement</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>Tidak ada</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Konstruksi Bangunan</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>Permanent</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Lantai</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>Keramik</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Dinding</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>Bata</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Atap</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>Genteng Beton</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Pondasi</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>Batu kali</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Perlengkapan Bangunan</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>Listrik : Ada</td>\n" +
            "                  <td class=\"another-key\">PAM :Ada</td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\"></td>\n" +
            "                  <td></td>\n" +
            "                  <td>Sumur/ Pompa : Ada</td>\n" +
            "                  <td class=\"another-key\">Pipa Gas : Tidak</td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Penggunaan Bangunan</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>Tempat Tinggal</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Penggunaan Saat ini</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>Tempat Tinggal</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                  <td class=\"key\">Tahun Dibangun / Renovasi</td>\n" +
            "                  <td>:</td>\n" +
            "                  <td>2000 / 2015</td>\n" +
            "                  <td class=\"another-key\"></td>\n" +
            "                </tr>\n" +
            "              </tbody></table>\n" +
            "\n" +
            "            </td>\n" +
            "          </tr>\n" +
            "          <tr>\n" +
            "            <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
            "              <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 150px;width: 250px;display: block;\n" +
            "              margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
            "              <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kanan</a>\n" +
            "            </td>\n" +
            "            <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
            "              <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 150px;width: 250px;display: block;\n" +
            "              margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
            "              <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kiri</a>\n" +
            "            </td>\n" +
            "          </tr>\n" +
            "        </tbody></table>\n" +
            "      </div>\n" +
            "      \n" +
            "      <div>\n" +
            "         <div style=\"font-size: 10px;font-weight: 600;margin-left: 13px;\">\n" +
            "          <a style=\"border-bottom: 2px solid black; color: black;\"> LINGKUNGAN SEKITAR</a> \n" +
            "         </div>\n" +
            "\n" +
            "         <table class=\"page1\" style=\"margin-left: 13px;margin-top: 6px;font-size: 9px;\">\n" +
            "          <tbody><tr>\n" +
            "            <td class=\"key\">Keadaan Lingkungan Sekitar</td>\n" +
            "            <td>:</td>\n" +
            "            <td>Perumahan</td>\n" +
            "            <td class=\"another-key\"></td>\n" +
            "            <td></td>\n" +
            "            <td></td>\n" +
            "          </tr>\n" +
            "          <tr>\n" +
            "            <td class=\"key\">Tingkat Hunian</td>\n" +
            "            <td>:</td>\n" +
            "            <td>75%</td>\n" +
            "            <td class=\"another-key\">Lokasi Aset</td>\n" +
            "            <td>:</td>\n" +
            "            <td>Pakai Sendiri</td>\n" +
            "          </tr>\n" +
            "          <tr>\n" +
            "            <td class=\"key\">Tipe Jalan</td>\n" +
            "            <td>:</td>\n" +
            "            <td>Aspal</td>\n" +
            "            <td class=\"another-key\">Letak Persil</td>\n" +
            "            <td>:</td>\n" +
            "            <td>Tengah</td>\n" +
            "          </tr>\n" +
            "          <tr>\n" +
            "            <td class=\"key\">Lebar Jalan</td>\n" +
            "            <td>:</td>\n" +
            "            <td>8 Meter</td>\n" +
            "            <td class=\"another-key\">Kapasitas Jalan</td>\n" +
            "            <td>:</td>\n" +
            "            <td>1 Kendaraan roda empat</td>\n" +
            "          </tr>\n" +
            "        </tbody></table>\n" +
            "      </div>\n" +
            "\n" +
            "       <div style=\"margin-left: 13px;font-size: 10px;font-weight: 600; margin-bottom: 10px;\">\n" +
            "         <a style=\"border-bottom: 2px solid black; color: black;\">KONDISI LINGKUNGAN KHUSUS</a>\n" +
            "       </div>\n" +
            "\n" +
            "       <div style=\"margin-bottom: 40px;\">\n" +
            "         \n" +
            "       </div>\n" +
            "\n" +
            "       <div style=\"font-size: 10px;font-weight: 600;margin-left: 13px; margin-bottom: 5px;\">\n" +
            "        <a style=\"border-bottom: 2px solid black; color: black;\">KETERANGAN TAMBAHAN LAINNYA</a> \n" +
            "       </div>\n" +
            "\n" +
            "       <div style=\"font-size: 10px;font-weight: 600;margin-left: 13px; margin-bottom: 20px;margin-right: 13px;\">\n" +
            "         <div style=\"border: 2px solid;\">\n" +
            "           <div style=\"text-align: center;color: white;border-bottom: 2px solid black;background: #808080;\"><a style=\"color: white;\">Penambah Nilai</a></div>\n" +
            "           <div>\n" +
            "            Photocopy IMB No. 648 / 449 - BP2T / 2016 yang kami terima adalah IMB sendiri dengan luas\n" +
            "            bangunan seluas 111,6 m² Tempat Tinggal TAMPAK DEPAN\n" +
            "            Photocopy IMB yang kami terima untuk tanggal penerbitan tidak tercopy\n" +
            "           </div>\n" +
            "           <div style=\"text-align: center;border-top: 2px solid black;border-bottom: 2px solid black;background: #808080;\"><a style=\"color: white;\">Pengurang Nilai</a></div>\n" +
            "           <div>\n" +
            "            Photocopy IMB No. 648 / 449 - BP2T / 2016 yang kami terima adalah IMB sendiri dengan luas\n" +
            "            bangunan seluas 111,6 m² Tempat Tinggal TAMPAK DEPAN\n" +
            "            Photocopy IMB yang kami terima untuk tanggal penerbitan tidak tercopy\n" +
            "           </div>\n" +
            "           <div style=\"text-align: center;\n" +
            "    border-top: 2px solid black;\n" +
            "    border-bottom: 2px solid black;\n" +
            "    background: #808080;\"><a style=\"color: white;\">Lain-lain</a></div>\n" +
            "           <div>\n" +
            "            Photocopy IMB No. 648 / 449 - BP2T / 2016 yang kami terima adalah IMB sendiri dengan luas\n" +
            "            bangunan seluas 111,6 m² Tempat Tinggal TAMPAK DEPAN\n" +
            "            Photocopy IMB yang kami terima untuk tanggal penerbitan tidak tercopy\n" +
            "           </div>\n" +
            "         </div>\n" +
            "       </div>\n" +
            "\n" +
            "        <div class=\"footer-page1\">\n" +
            "        <div class=\"data\" style=\"border: 2px solid;\">\n" +
            "          <table class=\"page1\" style=\"margin-left: 10px;\">\n" +
            "              <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"key\">No. LPPA</td>\n" +
            "                <td>:</td>\n" +
            "                <td>12345</td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\">No. Laporan</td>\n" +
            "                <td>:</td>\n" +
            "                <td>12345678</td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "            </tbody></table>\n" +
            "       </div>\n" +
            "       </div> \n" +
            "        </div>\n" +
            "      </div>\n" +
            "  </div>\n" +
            "  </div>\n" +
            "</body></html>";



    private static String page4(String encoded){
        return "<html><head>\n" +
                "  <style>\n" +
                ".border-page {  \n" +
                "  margin: 40px 50px 70px;\n" +
                "padding: 5px 3px;\n" +
                "border-color: black;\n" +
                "border-width: 3.5px;\n" +
                "border-style: double;\n" +
                "}\n" +
                ".border-page .inside-border{\n" +
                "  margin: 4px;\n" +
                "border-color: black;\n" +
                "border-width: 1.4px;\n" +
                "border-style: inset;\n" +
                "}\n" +
                "\n" +
                ".footer-page1 td:nth-child(3){\n" +
                "  width: 140px; \n" +
                "}\n" +
                "\n" +
                ".footer-page1 td, .footer-page1 th{\n" +
                "text-align: left;\n" +
                "padding-bottom: 2px;\n" +
                "font-size: 9px;\n" +
                "}\n" +
                "\n" +
                ".table-nilai td, .table-nilai th{\n" +
                "  border-left: 2px solid black;\n" +
                "  border-right: 2px solid black;\n" +
                "}\n" +
                "\n" +
                ".table-nilai th{\n" +
                "  background: #C4BB95;\n" +
                "    border: 2px solid black;\n" +
                "    width: 69.7px;\n" +
                "    font-size: 9px;\n" +
                "    height: 35px;\n" +
                "    text-align: center;\n" +
                "}\n" +
                "\n" +
                ".page1 td.key{\n" +
                "padding-right : 10px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".content-page1 .images, .footer{\n" +
                "  margin-left: 13px;\n" +
                "  margin-right: 13px;\n" +
                "  margin-top: 10px;\n" +
                "}\n" +
                "\n" +
                ".footer-page1{\n" +
                "  position: relative;\n" +
                "    top: -9px;\n" +
                "    margin-left: 13px;\n" +
                "    margin-right: 13px;\n" +
                "}\n" +
                "  </style>\n" +
                "  <link href=\"style.css\" rel=\"stylesheet\">\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div class=\"page-a4\">\n" +
                "  <div class=\"border-page\">\n" +
                "      <div class=\"inside-border\">\n" +
                "        <div class=\"page1\">\n" +
                "          <div class=\"header-page1\" style=\"margin-left: 5px;margin-right: 5px;position: relative;padding-bottom: 63px;\">\n" +
                "              <div class=\"right-sider\" style=\"display: flex;position: absolute;top: 0px;padding: 2px 4px;right: 40px;\">\n" +
                "                  <div>\n" +
                "                  <img src=\"https://kjppku.id/wp-content/uploads/2019/02/Logo-KJPP-1.png\" style=\"height: 33px;width: 55px;display: block;\n" +
                "margin-left: auto;\n" +
                "margin-right: auto;\">\n" +
                "                  <a style=\"font-size: 14px;color: black;\">Kjpp Harapan Baru</a>\n" +
                "                  </div>\n" +
                "              </div>\n" +
                "          </div>\n" +
                "\n" +
                "          <div class=\"original-value\" style=\"color: white;font-size: 9px;margin-bottom: 8px;padding: 2px 13px;background: #1F477B;\">\n" +
                "            <div>\n" +
                "              FOTO Aktiva\n" +
                "            </div>\n" +
                "          </div>\n" +
                "\n" +
                "          <div>\n" +
                "            <table class=\"page1\" style=\"margin-left: 10px;margin-bottom: 23px;\">\n" +
                "              <tbody>\n" +
                "                <tr>\n" +
                "                  <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
                "                    <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 130px;width: 250px;display: block;\n" +
                "                    margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
                "                    <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kiri</a>\n" +
                "                  </td>\n" +
                "                  <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
                "                    <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 130px;width: 250px;display: block;\n" +
                "                    margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
                "                    <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kiri</a>\n" +
                "                  </td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
                "                  <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 130px;width: 250px;display: block;\n" +
                "                  margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
                "                  <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kiri</a>\n" +
                "                </td>\n" +
                "                <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
                "                  <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 130px;width: 250px;display: block;\n" +
                "                  margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
                "                  <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kiri</a>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
                "                <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 130px;width: 250px;display: block;\n" +
                "                margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
                "                <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kiri</a>\n" +
                "              </td>\n" +
                "              <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
                "                <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 130px;width: 250px;display: block;\n" +
                "                margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
                "                <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kiri</a>\n" +
                "              </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
                "              <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 130px;width: 250px;display: block;\n" +
                "              margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
                "              <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kiri</a>\n" +
                "            </td>\n" +
                "            <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
                "              <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 130px;width: 250px;display: block;\n" +
                "              margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
                "              <a style=\"font-size: 9px; font-weight: 600;color: black;\">Tampak Sisi Kiri</a>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "            </tbody></table>\n" +
                "          </div>\n" +
                "\n" +
                "        <div class=\"footer-page1\">\n" +
                "        <div class=\"data\" style=\"border: 2px solid;\">\n" +
                "          <table class=\"page1\" style=\"margin-left: 10px;\">\n" +
                "              <tbody>\n" +
                "                <tr>\n" +
                "                <td class=\"key\">No. LPPA</td>\n" +
                "                <td>:</td>\n" +
                "                <td>12345</td>\n" +
                "                <td class=\"another-key\"></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "              </tr>\n" +
                "              <tr>\n" +
                "                <td class=\"key\">No. Laporan</td>\n" +
                "                <td>:</td>\n" +
                "                <td>12345678</td>\n" +
                "                <td class=\"another-key\"></td>\n" +
                "                <td></td>\n" +
                "                <td></td>\n" +
                "              </tr>\n" +
                "            </tbody></table>\n" +
                "       </div>\n" +
                "       </div> \n" +
                "        </div>\n" +
                "      </div>\n" +
                "  </div>\n" +
                "  </div>\n" +
                "</body></html>";
    }


    static String page5 = "<html><head>\n" +
            "  <style>\n" +
            ".border-page {  \n" +
            "  margin: 40px 50px 70px;\n" +
            "padding: 5px 3px;\n" +
            "border-color: black;\n" +
            "border-width: 3.5px;\n" +
            "border-style: double;\n" +
            "}\n" +
            ".border-page .inside-border{\n" +
            "  margin: 4px;\n" +
            "border-color: black;\n" +
            "border-width: 1.4px;\n" +
            "border-style: inset;\n" +
            "}\n" +
            "\n" +
            ".footer-page1 td:nth-child(3){\n" +
            "  width: 140px; \n" +
            "}\n" +
            "\n" +
            ".footer-page1 td, .footer-page1 th{\n" +
            "text-align: left;\n" +
            "padding-bottom: 2px;\n" +
            "font-size: 9px;\n" +
            "}\n" +
            "\n" +
            ".table-nilai td, .table-nilai th{\n" +
            "  border-left: 2px solid black;\n" +
            "  border-right: 2px solid black;\n" +
            "}\n" +
            "\n" +
            ".table-nilai th{\n" +
            "  background: #C4BB95;\n" +
            "    border: 2px solid black;\n" +
            "    width: 69.7px;\n" +
            "    font-size: 9px;\n" +
            "    height: 35px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".page1 td.key{\n" +
            "padding-right : 10px;\n" +
            "}\n" +
            "\n" +
            "\n" +
            ".content-page1 .images, .footer{\n" +
            "  margin-left: 13px;\n" +
            "  margin-right: 13px;\n" +
            "  margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".footer-page1{\n" +
            "  position: relative;\n" +
            "    top: -9px;\n" +
            "    margin-left: 13px;\n" +
            "    margin-right: 13px;\n" +
            "}\n" +
            "  </style>\n" +
            "  <link href=\"style.css\" rel=\"stylesheet\">\n" +
            "</head>\n" +
            "<body>\n" +
            "  <div class=\"page-a4\">\n" +
            "  <div class=\"border-page\">\n" +
            "      <div class=\"inside-border\">\n" +
            "        <div class=\"page1\">\n" +
            "          <div class=\"header-page1\" style=\"margin-left: 5px;margin-right: 5px;position: relative;padding-bottom: 63px;\">\n" +
            "              <div class=\"right-sider\" style=\"display: flex;position: absolute;top: 0px;padding: 2px 4px;right: 40px;\">\n" +
            "                  <div>\n" +
            "                  <img src=\"https://kjppku.id/wp-content/uploads/2019/02/Logo-KJPP-1.png\" style=\"height: 33px;width: 55px;display: block;\n" +
            "margin-left: auto;\n" +
            "margin-right: auto;\">\n" +
            "                  <a style=\"font-size: 14px;color: black;\">Kjpp Harapan Baru</a>\n" +
            "                  </div>\n" +
            "              </div>\n" +
            "          </div>\n" +
            "\n" +
            "          <div class=\"original-value\" style=\"color: white;font-size: 9px;margin-bottom: 17px;padding: 2px 13px;background: #1F477B;\">\n" +
            "            <div>\n" +
            "              DENAH TANAH DAN BANGUNAN\n" +
            "            </div>\n" +
            "          </div>\n" +
            "\n" +
            "          <div class=\"value-dis\" style=\"margin-bottom: 7px;\">\n" +
            "            <table class=\"\" style=\"margin-left: 10px;margin-right: 12px;border: 2px solid black;margin-bottom: 18px;\">\n" +
            "              <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
            "                  <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 150px;width: 250px;display: block;\n" +
            "                  margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
            "                  <a style=\"font-size: 9px; font-weight: 600;color: black;\">Denah Tanah</a>\n" +
            "                </td>\n" +
            "                <td>\n" +
            "                  <table class=\"page1\" style=\"font-size: 9px;\">\n" +
            "                    <tbody>\n" +
            "                      <tr>\n" +
            "                        <td colspan=\"3\" ><a style=\"border-bottom: 2px solid black; color: black; font-weight: 600;\">BATAS PERSIL</a></td>\n" +
            "                      </tr>                    \n" +
            "                      <tr>\n" +
            "                      <td class=\"key\">Mode Mata Angin</td>\n" +
            "                      <td>:</td>\n" +
            "                      <td></td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                      <td class=\"key\">Timur Laut</td>\n" +
            "                      <td>:</td>\n" +
            "                      <td>Jalan</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                      <td class=\"key\">Tenggara</td>\n" +
            "                      <td>:</td>\n" +
            "                      <td>Rumah</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                      <td class=\"key\">Barat Daya</td>\n" +
            "                      <td>:</td>\n" +
            "                      <td>Jalan</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                      <td class=\"key\">Barat Laut</td>\n" +
            "                      <td>:</td>\n" +
            "                      <td>Rumah</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                      <td colspan=\"3\" style=\"padding-bottom: 10px; padding-top: 10px;\"><a style=\"border-bottom: 2px solid black; color: black; font-weight: 600;\">TITIK KOORDINAT AGUNAN</a></td>\n" +
            "                    </tr>                    \n" +
            "                    <tr>\n" +
            "                    </tr><tr>\n" +
            "                      <td class=\"key\">Koordinat</td>\n" +
            "                      <td>:</td>\n" +
            "                      <td>Decimal</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                      <td class=\"key\">Latitude</td>\n" +
            "                      <td>:</td>\n" +
            "                      <td>- 6.23641</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                      <td class=\"key\">Longitude</td>\n" +
            "                      <td>:</td>\n" +
            "                      <td>+ 106.67943: + 106.67943</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                      <td colspan=\"3\" style=\"padding-top: 10px;\"><a style=\"border-bottom: 2px solid black; color: black; font-weight: 600;\">TITIK KOORDINAT AGUNAN</a></td>\n" +
            "                    </tr> \n" +
            "                    <tr>\n" +
            "                      <td class=\"key\">Ketinggian tanah</td>\n" +
            "                      <td>:</td>\n" +
            "                      <td>0,3 m</td>\n" +
            "                    </tr>\n" +
            "                    <tr>\n" +
            "                      <td colspan=\"3\">(dibandingkan jalan)</td>\n" +
            "                    </tr> \n" +
            "                  </tbody></table>\n" +
            "    \n" +
            "                </td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
            "                  <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"height: 150px;width: 250px;display: block;\n" +
            "                  margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
            "                  <a style=\"font-size: 9px; font-weight: 600;color: black;\">Denah Bangunan</a>\n" +
            "                </td>\n" +
            "                <td class=\"key\" style=\"border: 2px solid black;text-align: center;\">\n" +
            "                  <div style=\"height: 150px;width: 250px;\"></div>\n" +
            "                  <a style=\"font-size: 9px; font-weight: 600;color: black;\">Keterangan Lain</a>\n" +
            "                </td>\n" +
            "              </tr>\n" +
            "            </tbody></table>\n" +
            "          </div>\n" +
            "\n" +
            "          <div class=\"original-value\" style=\"color: white;font-size: 9px;margin-bottom: 17px;padding: 2px 13px;background: #1F477B;\">\n" +
            "            <div>\n" +
            "              PETA LOKASI AGUNAN DAN DATA PEMBANDING\n" +
            "            </div>\n" +
            "          </div>\n" +
            "\n" +
            "          <div style=\"border: 2px solid black;margin-right: 13px;margin-left: 13px;margin-bottom: 22px;padding-bottom: 10px;padding-top: 10px;\">\n" +
            "            <img src=\"https://statik.tempo.co/data/2019/01/23/id_813830/813830_720.jpg\" style=\"height: 150px;width: 250px;display: block;\n" +
            "            margin-bottom: 12px;margin-left: auto; margin-right: auto;\">\n" +
            "          </div>\n" +
            "\n" +
            "\n" +
            "        <div class=\"footer-page1\">\n" +
            "        <div class=\"data\" style=\"border: 2px solid;\">\n" +
            "          <table class=\"page1\" style=\"margin-left: 10px;\">\n" +
            "              <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"key\">No. LPPA</td>\n" +
            "                <td>:</td>\n" +
            "                <td>12345</td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\">No. Laporan</td>\n" +
            "                <td>:</td>\n" +
            "                <td>12345678</td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "            </tbody></table>\n" +
            "       </div>\n" +
            "       </div> \n" +
            "        </div>\n" +
            "      </div>\n" +
            "  </div>\n" +
            "  </div>\n" +
            "</body></html>";

    static String page6 = "<html><head>\n" +
            "  <style>\n" +
            ".border-page {  \n" +
            "  margin: 40px 50px 70px;\n" +
            "padding: 5px 3px;\n" +
            "border-color: black;\n" +
            "border-width: 3.5px;\n" +
            "border-style: double;\n" +
            "}\n" +
            ".border-page .inside-border{\n" +
            "  margin: 4px;\n" +
            "border-color: black;\n" +
            "border-width: 1.4px;\n" +
            "border-style: inset;\n" +
            "}\n" +
            "\n" +
            ".footer-page1 td:nth-child(3){\n" +
            "  width: 140px; \n" +
            "}\n" +
            "\n" +
            ".footer-page1 td, .footer-page1 th{\n" +
            "text-align: left;\n" +
            "padding-bottom: 2px;\n" +
            "font-size: 9px;\n" +
            "}\n" +
            "\n" +
            ".table-nilai td, .table-nilai th{\n" +
            "  border-left: 2px solid black;\n" +
            "  border-right: 2px solid black;\n" +
            "}\n" +
            "\n" +
            ".table-nilai th{\n" +
            "  background: #C4BB95;\n" +
            "    border: 2px solid black;\n" +
            "    width: 69.7px;\n" +
            "    font-size: 9px;\n" +
            "    height: 35px;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            ".page1 td.key{\n" +
            "padding-right : 10px;\n" +
            "}\n" +
            "\n" +
            "\n" +
            ".content-page1 .images, .footer{\n" +
            "  margin-left: 13px;\n" +
            "  margin-right: 13px;\n" +
            "  margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            ".footer-page1{\n" +
            "  position: relative;\n" +
            "    top: -9px;\n" +
            "    margin-left: 13px;\n" +
            "    margin-right: 13px;\n" +
            "}\n" +
            "  </style>\n" +
            "  <link href=\"style.css\" rel=\"stylesheet\">\n" +
            "</head>\n" +
            "<body>\n" +
            "  <div class=\"page-a4\">\n" +
            "  <div class=\"border-page\">\n" +
            "      <div class=\"inside-border\">\n" +
            "        <div class=\"page1\">\n" +
            "          <div class=\"header-page1\" style=\"margin-left: 5px;margin-right: 5px;position: relative;padding-bottom: 63px;\">\n" +
            "              <div class=\"right-sider\" style=\"display: flex;position: absolute;top: 0px;padding: 2px 4px;right: 40px;\">\n" +
            "                  <div>\n" +
            "                  <img src=\"https://kjppku.id/wp-content/uploads/2019/02/Logo-KJPP-1.png\" style=\"height: 33px;width: 55px;display: block;\n" +
            "margin-left: auto;\n" +
            "margin-right: auto;\">\n" +
            "                  <a style=\"font-size: 14px;color: black;\">Kjpp Harapan Baru</a>\n" +
            "                  </div>\n" +
            "              </div>\n" +
            "          </div>\n" +
            "\n" +
            "         \n" +
            "          <div class=\"original-value\" style=\"color: white;font-size: 9px;margin-bottom: 17px;padding: 2px 13px;background: #1F477B;\">\n" +
            "            <div>\n" +
            "              DATA PEMBANDING\n" +
            "            </div>\n" +
            "          </div>\n" +
            "\n" +
            "          <p style=\"font-size: 9px;margin-bottom: 26px;padding-left: 11px;\">Data pasar penawaran dan atau transaksi yang dapat dijadikan pembanding dalam penilaian ini adalah sebagai berikut :</p>\n" +
            "\n" +
            "          <div style=\"border: 2px solid black;margin-top: -11px;margin-bottom: 22px;margin-right: 13px;margin-left: 13px;padding: 13px 20px;\">\n" +
            "            <table class=\"\" style=\"margin-left: 10px;margin-right: 12px;margin-bottom: 30px;\">\n" +
            "              <tbody>\n" +
            "                <tr>\n" +
            "                  <td style=\"width: 226px;\">\n" +
            "                    <table class=\"page1\" style=\"font-size: 9px;\">\n" +
            "                      <tbody>\n" +
            "                        <tr>\n" +
            "                          <td colspan=\"3\"><a style=\"color: black; font-weight: 600;\">Data 1</a></td>\n" +
            "                        </tr>                    \n" +
            "                        <tr>\n" +
            "                        <td class=\"key\">Alamat Pembanding</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Jl. Abcefgh no 14</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Luas Tanah/ Bangunan</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>90 / 135</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Surat Tanah/ Legalitas</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>SHM</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Tanggal Penawaran</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>05-04-2022</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Harga Penawaran (Rp)</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>1.440.000.000</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Perkiraan Transaksi</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>1.200.000.000</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Narasumber</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Bpk ABCD</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">No. Telpon</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>0812345678</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Jarak dengan Aktiva yang Dinilai</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>100 m</td>\n" +
            "                      </tr>\n" +
            "                    </tbody></table>\n" +
            "      \n" +
            "                  </td>\n" +
            "                <td class=\"key\" style=\"position: relative;\">\n" +
            "                  <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"top: 0px;left: 10px;position: absolute;height: 149px;width: 239px;display: block;\n" +
            "                  margin-bottom: 12px;margin-left: auto; padding: 10px 5px;margin-right: auto;border: 2px solid black;\">\n" +
            "                  \n" +
            "                </td>\n" +
            "              </tr>\n" +
            "              \n" +
            "            </tbody></table>\n" +
            "\n" +
            "            <table class=\"\" style=\"margin-left: 10px;margin-right: 12px;margin-bottom: 30px;\">\n" +
            "              <tbody>\n" +
            "                <tr>\n" +
            "                  <td style=\"width: 226px;\">\n" +
            "                    <table class=\"page1\" style=\"font-size: 9px;\">\n" +
            "                      <tbody>\n" +
            "                        <tr>\n" +
            "                          <td colspan=\"3\"><a style=\"color: black; font-weight: 600;\">Data 1</a></td>\n" +
            "                        </tr>                    \n" +
            "                        <tr>\n" +
            "                        <td class=\"key\">Alamat Pembanding</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Jl. Abcefgh no 14</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Luas Tanah/ Bangunan</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>90 / 135</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Surat Tanah/ Legalitas</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>SHM</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Tanggal Penawaran</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>05-04-2022</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Harga Penawaran (Rp)</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>1.440.000.000</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Perkiraan Transaksi</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>1.200.000.000</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Narasumber</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Bpk ABCD</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">No. Telpon</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>0812345678</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Jarak dengan Aktiva yang Dinilai</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>100 m</td>\n" +
            "                      </tr>\n" +
            "                    </tbody></table>\n" +
            "      \n" +
            "                  </td>\n" +
            "                <td class=\"key\" style=\"position: relative;\">\n" +
            "                  <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"top: 0px;left: 10px;position: absolute;height: 149px;width: 239px;display: block;\n" +
            "                  margin-bottom: 12px;margin-left: auto; padding: 10px 5px;margin-right: auto;border: 2px solid black;\">\n" +
            "                  \n" +
            "                </td>\n" +
            "              </tr>\n" +
            "              \n" +
            "            </tbody></table>\n" +
            "\n" +
            "\n" +
            "            <table class=\"\" style=\"margin-left: 10px;margin-right: 12px;margin-bottom: 30px;\">\n" +
            "              <tbody>\n" +
            "                <tr>\n" +
            "                  <td style=\"width: 226px;\">\n" +
            "                    <table class=\"page1\" style=\"font-size: 9px;\">\n" +
            "                      <tbody>\n" +
            "                        <tr>\n" +
            "                          <td colspan=\"3\"><a style=\"color: black; font-weight: 600;\">Data 1</a></td>\n" +
            "                        </tr>                    \n" +
            "                        <tr>\n" +
            "                        <td class=\"key\">Alamat Pembanding</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Jl. Abcefgh no 14</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Luas Tanah/ Bangunan</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>90 / 135</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Surat Tanah/ Legalitas</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>SHM</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Tanggal Penawaran</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>05-04-2022</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Harga Penawaran (Rp)</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>1.440.000.000</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Perkiraan Transaksi</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>1.200.000.000</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Narasumber</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>Bpk ABCD</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">No. Telpon</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>0812345678</td>\n" +
            "                      </tr>\n" +
            "                      <tr>\n" +
            "                        <td class=\"key\">Jarak dengan Aktiva yang Dinilai</td>\n" +
            "                        <td>:</td>\n" +
            "                        <td>100 m</td>\n" +
            "                      </tr>\n" +
            "                    </tbody></table>\n" +
            "      \n" +
            "                  </td>\n" +
            "                <td class=\"key\" style=\"position: relative;\">\n" +
            "                  <img src=\"https://i0.wp.com/www.nesabamedia.com/wp-content/uploads/2019/08/maxresdefault-3.jpg?fit=1280%2C720&amp;ssl=1\" style=\"top: 0px;left: 10px;position: absolute;height: 149px;width: 239px;display: block;\n" +
            "                  margin-bottom: 12px;margin-left: auto; padding: 10px 5px;margin-right: auto;border: 2px solid black;\">\n" +
            "                  \n" +
            "                </td>\n" +
            "              </tr>\n" +
            "              \n" +
            "            </tbody></table>\n" +
            "\n" +
            "<p style=\"text-align: center;font-size: 9px;padding-top: 12px;\">Lembar data pembanding ini hanya digunakan untuk keperluan PT. Bank Central Asia, Tbk</p>\n" +
            "            \n" +
            "          </div>\n" +
            "\n" +
            "          \n" +
            "\n" +
            "        <div class=\"footer-page1\">\n" +
            "        <div class=\"data\" style=\"border: 2px solid;\">\n" +
            "          <table class=\"page1\" style=\"margin-left: 10px;\">\n" +
            "              <tbody>\n" +
            "                <tr>\n" +
            "                <td class=\"key\">No. LPPA</td>\n" +
            "                <td>:</td>\n" +
            "                <td>12345</td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "              <tr>\n" +
            "                <td class=\"key\">No. Laporan</td>\n" +
            "                <td>:</td>\n" +
            "                <td>12345678</td>\n" +
            "                <td class=\"another-key\"></td>\n" +
            "                <td></td>\n" +
            "                <td></td>\n" +
            "              </tr>\n" +
            "            </tbody></table>\n" +
            "       </div>\n" +
            "       </div> \n" +
            "        </div>\n" +
            "      </div>\n" +
            "  </div>\n" +
            "  </div>\n" +
            "</body></html>";

    public static void main(String args[]) throws Exception {
        OutputStream os = null;
        try {
            //final File outputFile = File.createTempFile("C:/CONTOH-PDF/sample",".pdf");
            final File outputFile = new File("C:/CONTOH-PDF/sample.pdf");
            os = new FileOutputStream(outputFile);

            ITextRenderer renderer = new ITextRenderer();

            Document documentPage1 = Jsoup.parse(page1);
            documentPage1.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
            renderer.setDocumentFromString(documentPage1.html());
            renderer.layout();
            renderer.createPDF(os,false);

            Document documentPage2 = Jsoup.parse(page2);
            documentPage2.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
            renderer.setDocumentFromString(documentPage2.html());
            renderer.layout();
            renderer.writeNextDocument();

            Document documentPage3 = Jsoup.parse(page3);
            documentPage3.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
            renderer.setDocumentFromString(documentPage3.html());
            renderer.layout();
            renderer.writeNextDocument();


            Document documentPage4 = Jsoup.parse(page4(encodedFile("C:/Contoh-Gambar/gambar-rumah-minimalis-3.jpg")));
            documentPage4.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
            renderer.setDocumentFromString(documentPage4.html());
            renderer.layout();
            renderer.writeNextDocument();

            Document documentPage5 = Jsoup.parse(page5);
            documentPage5.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
            renderer.setDocumentFromString(documentPage5.html());
            renderer.layout();
            renderer.writeNextDocument();

            Document documentPage6 = Jsoup.parse(page6);
            documentPage6.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
            renderer.setDocumentFromString(documentPage6.html());
            renderer.layout();
            renderer.writeNextDocument();

            renderer.finishPDF();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static String encodedFile(String filePath){
        String ext = FilenameUtils.getExtension(filePath);
        System.out.println(ext);
        String dataImage = "data:image/jpeg;base64,";
        if(ext.equalsIgnoreCase("png")){
            dataImage = "data:image/png;base64,";
        }

        byte[] fileContent;
        try {
            fileContent = FileUtils.readFileToByteArray(new File(filePath));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            return dataImage+encodedString;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
