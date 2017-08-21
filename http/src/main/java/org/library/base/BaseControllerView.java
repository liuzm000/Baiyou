package org.library.base;

import java.util.List;

import org.library.utils.MapV2;

public interface BaseControllerView {

	void updateList(int id, List<MapV2> data);

//	void onSuccess(int id, String msg);
//
//	void onFailed(int id, String msg);

	void refresh();

	void loadMore();
	
//	void loadStart();
	
}
