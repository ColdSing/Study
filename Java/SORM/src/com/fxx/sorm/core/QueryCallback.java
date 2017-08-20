package com.fxx.sorm.core;

import java.sql.ResultSet;
import java.util.List;

public interface QueryCallback {
	public Object doExcute(ResultSet rs);
}
