//package sun.common.widget.dialog;
//
//
//
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import sun.common.R;
//
///**
//  自定义 弹出框
//【示例1】： 确定与取消
//CustomAlertDialog customAlertDialog = new CustomAlertDialog(context);
//customAlertDialog.setMessage("提示内容");
//customAlertDialog.setNegativeButton("取消",new CustomAlertDialogClickListener() {
//	@Override
//	public boolean onclick(View v) {
//		// TODO Auto-generated method stub
//		return false; //实现的接口: 返回true 则不关闭dialog
//	}
//
//});
//customAlertDialog.setPositiveButton("确定",new CustomAlertDialogClickListener() {
//	@Override
//	public boolean onclick(View v) {
//		// TODO Auto-generated method stub
//		return false;//实现的接口: 返回true 则不关闭dialog
//	}
//});
//【示例2】：单选列表
//CustomAlertDialog customAlertDialog = new CustomAlertDialog(context);
//String[] StrLists = {"修改","删除","确定","删除","确定","删除","确定","删除","确定","删除"};  //最多10项
//customAlertDialog.setItemSingleClick(StrLists, new CustomAlertDialog.CustomAlertDialogItemClickListener() {
//   @Override
//   public boolean itemclick(View view, int position, long id) {
//		// TODO Auto-generated method stub
//		return false;//实现的接口: 返回true 则不关闭dialog
//	}
//});
//
// * @author sundy
// */
//public class SingleChooseDialog{
//
//	private Context context;
//	private AlertDialog alertDialog;
//	private Window window;
//	private LayoutInflater flater;
////	private View defaultView;
//	private LinearLayout titleLayout;
//	private TextView title,message;
//	private Button positiveButton,negativeButton;
//	private ListView listView;
//
//	public SingleChooseDialog(Context context) {
//		this.context = context;
//		alertDialog = new AlertDialog.Builder(context).create();
//		alertDialog.setCanceledOnTouchOutside(true);
//		alertDialog.show();
//		window = alertDialog.getWindow();
//		flater = LayoutInflater.from(context);
//	}
//
//	public SingleChooseDialog(Context context,boolean CanceledOnTouchOutside) {
//		this.context = context;
//		alertDialog = new AlertDialog.Builder(context).create();
//		if( !CanceledOnTouchOutside ){
//			alertDialog.setCanceledOnTouchOutside(false);
//		}else{
//			alertDialog.setCanceledOnTouchOutside(true);
//		}
//		alertDialog.show();
//		window = alertDialog.getWindow();
//		flater = LayoutInflater.from(context);
//	}
//
//	private void initDefaultWedget(){
//		window.setContentView(R.layout.my_view_custom_alertdialog_default);
//		titleLayout = (LinearLayout)window.findViewById(R.id.title_layout);
//		title = (TextView)window.findViewById(R.id.title);
//		message = (TextView)window.findViewById(R.id.message);
//		positiveButton = (Button)window.findViewById(R.id.positiveButton);
//		negativeButton = (Button)window.findViewById(R.id.negativeButton);
//	}
//	private void initSingleWegget(){
//		window.setContentView(R.layout.single_dialog_item);
//		listView = (ListView)window.findViewById(R.id.singleListView);
//	}
//
//	private void initSingleTwoWegget(){
//		window.setContentView(R.layout.my_view_custom_alertdialog_two_singleclick);
//		titleLayout = (LinearLayout)window.findViewById(R.id.title_layout);
//		title = (TextView)window.findViewById(R.id.title);
//		listView = (ListView)window.findViewById(R.id.singleListTwoView);
//	}
//
//	public SingleChooseDialog setMessage( String msg ){
//		if( message == null ){
//			initDefaultWedget();
//		}
//		message.setText(msg+"");
//		return this;
//	}
//
//	public SingleChooseDialog setTitle( String text ){
//		if( title == null ){
//			initDefaultWedget();
//		}
//		title.setText(text+"");
//		titleLayout.setVisibility(View.VISIBLE);
//		return this;
//	}
//
//	/**
//	 * 设置确定按钮 (可以不设置，则不显示)
//	 * @param text
//	 * @param alertDialogInterface
//	 * @return
//	 */
//	public SingleChooseDialog setPositiveButton( String text,final CustomAlertDialogClickListener alertDialogInterface ){
//		if( positiveButton == null ){
//			initDefaultWedget();
//		}
//		if( text != null ){
//			positiveButton.setText(text);
//			positiveButton.setVisibility(View.VISIBLE);
//		}
//		/**
//		 * 实现的接口 返回true 则不关闭dialog
//		 */
//		positiveButton.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if( alertDialogInterface == null || !alertDialogInterface.onclick(v) ){
//					dismiss();
//				}
//			}
//		});
//		return this;
//	}
//
//	/**
//	 * 设置取消按钮（可以不设置，则不显示）
//	 * @param text
//	 * @param alertDialogInterface
//	 * @return
//	 */
//	public SingleChooseDialog setNegativeButton( String text,final CustomAlertDialogClickListener alertDialogInterface ){
//		if( negativeButton == null ){
//			initDefaultWedget();
//		}
//		if( text != null ){
//			negativeButton.setText(text);
//			negativeButton.setVisibility(View.VISIBLE);
//		}
//		negativeButton.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if( alertDialogInterface == null || !alertDialogInterface.onclick(v) ){
//					dismiss();
//				}
//			}
//		});
//		return this;
//	}
//
//
//	/**
//	 * 单选列表
//	 * @param textArr
//	 * @param alertDialogItemClickListener
//	 */
//	public void setItemSingleClick( String[] textArr,final CustomAlertDialogItemClickListener alertDialogItemClickListener){
//		if( listView == null ){
//			initSingleWegget();
//		}
//		if( textArr != null && textArr.length > 0 ){
//			SingleAdapter singleAdapter = new SingleAdapter(context, R.layout.dialog_ope_item,textArr);
//			if( listView != null ){
//				listView.setAdapter(singleAdapter);
//				listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//					@Override
//					public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
//						if(	!alertDialogItemClickListener.itemclick(view, position, id) ){
//							dismiss();
//						}
//					}
//				});
//			}
//		}
//	}
//
//	class SingleAdapter extends ArrayAdapter<String>{
//
//		private int resourceId;
//		private Context context;
//
//		public SingleAdapter(Context context, int resource, String[] objects) {
//			super(context, resource, objects);
//			this.resourceId = resource;
//		}
//
//		@Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			String item = getItem(position);
//	        convertView = flater.inflate(resourceId, null);
//	        TextView itemText = (TextView)convertView.findViewById(R.id.itemText);
//	        itemText.setText(item);
//	        return convertView;
//		}
//	}
//
//
//	/**
//	 * 单选列表(带标题，选择对号框)
//	 * @param textArr
//	 * @param alertDialogItemClickListener
//	 */
//	public void setItemTwoSingleClick( String text,String[] textArr,int selected,final CustomAlertDialogItemClickListener alertDialogItemClickListener){
//		if( listView == null ){
//			initSingleTwoWegget();
//			titleLayout.setVisibility(View.VISIBLE);
//			title.setText(text+"");
//		}
//		if( textArr != null && textArr.length > 0 ){
//			SingleTwoAdapter singleTwoAdapter = new SingleTwoAdapter(context, R.layout.my_view_custom_alertdialog_two_singleclick_item,textArr,selected);
//			if( listView != null ){
//				listView.setAdapter(singleTwoAdapter);
//				listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//					@Override
//					public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
//						if(	!alertDialogItemClickListener.itemclick(view, position, id) ){
//							dismiss();
//						}
//					}
//				});
//			}
//		}
//	}
//
//	class SingleTwoAdapter extends ArrayAdapter<String>{
//
//		private int resourceId;
//		private Context context;
//		private int selected;
//
//		public SingleTwoAdapter(Context context, int resource,String[] objects,int selected) {
//			super(context, resource, objects);
//			this.resourceId = resource;
//			this.selected=selected;
//		}
//
//		@Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			String item = getItem(position);
//	        convertView = flater.inflate(resourceId, null);
//	        TextView itemText = (TextView)convertView.findViewById(R.id.itemText);
//	        ImageView selectImageOnView = (ImageView)convertView.findViewById(R.id.itemSelectOn);
//	        ImageView selectImageOffView = (ImageView)convertView.findViewById(R.id.itemSelectOff);
//	        if(position==selected){
//	        	selectImageOnView.setVisibility(View.VISIBLE);
//	        	selectImageOffView.setVisibility(View.GONE);
//	        }else{
//	        	selectImageOnView.setVisibility(View.GONE);
//	        	selectImageOffView.setVisibility(View.VISIBLE);
//	        }
//	        itemText.setText(item);
//	        return convertView;
//		}
//	}
//
//
//
//
//
//
//	/**
//	 * 关闭弹出框
//	 */
//	public void dismiss(){
//		alertDialog.dismiss();
//	}
//
//	public interface CustomAlertDialogClickListener{
//		public boolean onclick(View v);
//	}
//
//	public interface CustomAlertDialogItemClickListener{
//		public boolean itemclick(View view, int position, long id);
//	}
//
//}
