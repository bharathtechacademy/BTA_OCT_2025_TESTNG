package com.creatio.crm.framework.db.commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creatio.crm.framework.utilities.DBUtil;

public class DBCommons {
	
	//Common method to read and convert the raw data into List of Maps.
		public static List<Map<String, String>> getData(String query) throws SQLException {
					
			//create a empty list of maps.
			List<Map<String, String>> data = new ArrayList<>();
			
			//get the raw data from database.
			ResultSet rs = DBUtil.executeQuery(query);
			
			//convert the raw data into list of maps.
			while(rs.next()) { //if there is data present in the ResultSet, go to next row
				
				//create a empty map for each row.
				Map<String, String> rowData =  new HashMap<String, String>();
							
				//Convert the resultset into map.
				for(int c=1;c<=rs.getMetaData().getColumnCount(); c++) {
					String columnName = rs.getMetaData().getColumnName(c);
					String columnValue = rs.getString(c);
					rowData.put(columnName, columnValue);				
				}
				
				//add each row data into list
				data.add(rowData);						
					
			}	

			return data;
		}

}
