package ben.study.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

import ben.study.codeduan1.R;
import ben.study.database.DatabaseDuAn1;
import ben.study.database.NhapKhoDAO;
import ben.study.model.KhoModel;

public class AdapterDanhSachSanPhamTrongKho extends BaseAdapter {
    private ArrayList<KhoModel> khoModels ;
    private Context context;
    public AdapterDanhSachSanPhamTrongKho(List<KhoModel> khoModels, Context context){
        this.khoModels = (ArrayList<KhoModel>) khoModels;
        this.context = context;
    }
    @Override
    public int getCount() {
        return khoModels.size();
    }

    @Override
    public Object getItem(int i) {
        return khoModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_listview_danhsach_nhapkho,viewGroup,false);

        TextView txtLvTenHangNK = view.findViewById(R.id.txtLvTenHangNK);
        TextView txtLvTenTheLoaiNK = view.findViewById(R.id.txtLvTenTheLoaiNK);
        TextView txtLvSoLuongNK = view.findViewById(R.id.txtLvSoLuongNK);
        TextView txtLvGiaNK =view.findViewById(R.id.txtLvGiaNK);

        txtLvTenHangNK.setText(khoModels.get(i).getTenHang());
        txtLvTenTheLoaiNK.setText(khoModels.get(i).getTheloaihang());
        txtLvSoLuongNK.setText(String.valueOf(khoModels.get(i).getSoLuong()));
        txtLvGiaNK.setText(String.valueOf(khoModels.get(i).getGia()));
        view.findViewById(R.id.imgLvXoaNK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("X??a Th??? Lo???i H??ng");
                builder.setTitle("B???n c?? ch???c mu???n x??a th??? lo???i h??ng n??y kh??ng , l??u ?? khi x??a th??? lo???i h??ng n??y s??? m???t v??nh vi???n.!");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i1) {
                        DatabaseDuAn1 databaseDuAn1 = new DatabaseDuAn1(view.getContext());
                        NhapKhoDAO nhapKhoDAO = new NhapKhoDAO(databaseDuAn1);
                        String ma = khoModels.get(i).getMaHang();
                        boolean ketQua = nhapKhoDAO.xoahangtrongkhonhap(ma);
                        if (ketQua) {
                            Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!" ,
                                    Toast.LENGTH_SHORT).show();
                            khoModels.remove(i);
                            notifyDataSetChanged();
                        } else {
                            Toast.makeText(viewGroup.getContext(), "Xoa KHONG Thanh Cong!!!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(),"",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });

        view.findViewById(R.id.imgLvNK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Object object = khoModels.get(i);
                Toast.makeText(context,"????y l??: " + object,Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
