package com.architecture.padawans.views.place.list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.architecture.padawans.R;
import com.padawans.data.entities.place.PlaceEntity;
import com.squareup.picasso.Picasso;
import java.util.Collection;
import java.util.List;

/**
 * Adaptar that manages a collection of {@link PlaceEntity}.
 */
public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.UserViewHolder> {

  public interface OnItemClickListener {
    void onPlaceItemClicked(PlaceEntity placeEntity);
  }

  private List<PlaceEntity> placesCollection;
  private Context context;
  private final LayoutInflater layoutInflater;

  private OnItemClickListener onItemClickListener;

  public PlacesAdapter(Context context, Collection<PlaceEntity> placesCollection) {
    this.validatePlacesCollection(placesCollection);
    this.layoutInflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.placesCollection = (List<PlaceEntity>) placesCollection;
    this.context = context;
  }

  @Override public int getItemCount() {
    return (this.placesCollection != null) ? this.placesCollection.size() : 0;
  }

  @Override public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = this.layoutInflater.inflate(R.layout.row_place, parent, false);
    UserViewHolder userViewHolder = new UserViewHolder(view);
    return userViewHolder;
  }

  @Override public void onBindViewHolder(UserViewHolder holder, final int position) {
    final PlaceEntity placeEntity = this.placesCollection.get(position);
    holder.textViewTitle.setText(placeEntity.getName());
    Picasso.with(context)
        .load(placeEntity.getPhoto())
        .into(holder.imgAvatar);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (PlacesAdapter.this.onItemClickListener != null) {
          PlacesAdapter.this.onItemClickListener.onPlaceItemClicked(placeEntity);
        }
      }
    });
  }

  @Override public long getItemId(int position) {
    return position;
  }

  public void setPlacesCollection(Collection<PlaceEntity> placesCollection) {
    this.validatePlacesCollection(placesCollection);
    this.placesCollection = (List<PlaceEntity>) placesCollection;
    this.notifyDataSetChanged();
  }

  public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }

  private void validatePlacesCollection(Collection<PlaceEntity> placesCollection) {
    if (placesCollection == null) {
      throw new IllegalArgumentException("The list cannot be null");
    }
  }

  static class UserViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.name) TextView textViewTitle;
    @Bind(R.id.avatar) ImageView imgAvatar;

    public UserViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}