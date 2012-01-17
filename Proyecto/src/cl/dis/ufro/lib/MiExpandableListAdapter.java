package cl.dis.ufro.lib;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MiExpandableListAdapter extends BaseExpandableListAdapter {

	private String[] grupos = {"Curso 1", "Curso 2", "Curso 3"};
	private String[][] opciones = { {"Sincronizar curso"}, 
									{"Ver tareas", "Ver recursos", "Ver archivos guardados", "Sincronizar curso"}, 
									{"Ver tareas", "Ver recursos", "Sincronizar curso"} };
	private Context contexto;
	
	public MiExpandableListAdapter(Context context){
		super();
		this.contexto = context;
	}
	
	public Object getChild(int groupPosition, int childPosition) {
		return opciones[groupPosition][childPosition];
	}

	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	public int getChildrenCount(int groupPosition) {
		int i = 0;
		try {
			i = opciones[groupPosition].length;
		} catch (Exception e) {}

		return i;
	}

	public TextView getGenericView() {
		// Layout parameters for the ExpandableListView
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
		TextView textView = new TextView(this.contexto);
		textView.setLayoutParams(lp);
		// Center the text vertically
		textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		textView.setTextColor(android.R.color.white);
		// Set the text starting position
		textView.setPadding(36, 0, 0, 0);
		return textView;
	}

	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		TextView textView = getGenericView();
		textView.setText(getChild(groupPosition, childPosition).toString());
		return textView;
	}

	public Object getGroup(int groupPosition) {
		return grupos[groupPosition];
	}

	public int getGroupCount() {
		return grupos.length;
	}

	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		TextView textView = getGenericView();
		textView.setText(getGroup(groupPosition).toString());
		return textView;
	}

	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	public boolean hasStableIds() {
		return true;
	}

}
