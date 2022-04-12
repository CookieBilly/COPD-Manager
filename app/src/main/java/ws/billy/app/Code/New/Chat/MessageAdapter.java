package ws.billy.app.Code.New.Chat;

import android.content.Context;
import android.graphics.Typeface;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ws.billy.app.tools.ImageViewCircleTransform;
import ws.billy.app.R;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ItemViewHolder> {
    private static ArrayList<Message> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public MessageAdapter(Context ctx, ArrayList<Message> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView textName;
        private TextView textTime;

        public ItemViewHolder(View itemView) {
            super(itemView);

            //textTime = (ImageView) itemView.findViewById(R.id.imgProfile);
            //textName = (TextView) itemView.findViewById(R.id.textName);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chat, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        Spannable word = new SpannableString(dataList.get(position).getText());
        word.setSpan(new StyleSpan(Typeface.BOLD), 0, word.length(), 0);
        holder.textName.setText(word);

        Spannable wordTwo = new SpannableString(" " + dataList.get(position).getText());
        holder.textName.append(wordTwo);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
