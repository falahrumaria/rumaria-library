package myTrial;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class myQueryWork {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("product_code", "ab");
		map.put("product_name", "ab");

		System.out.println(getAndClause(map.entrySet()));

		StringBuilder sb = new StringBuilder("gue ");
		sb.append("falah");
		System.out.println(sb);
	}

	private static String getAndClause(Set<Entry<String, String>> entrySet) {
		if (entrySet.isEmpty()) {
			return "";
		}
		String andClause = "AND (";
		Iterator<Entry<String, String>> itr = entrySet.iterator();
		while (itr.hasNext()) {
			Entry<String, String> entry = (Entry<String, String>) itr.next();
			andClause += "UPPER(" + entry.getKey() + ") LIKE '%" + entry.getValue() + "%'";
			if (itr.hasNext()) {
				andClause += " OR ";
			}
		}
		andClause += ")";
		return andClause;
	}
}
