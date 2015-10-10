package MineralClassification;

<<<<<<< f0338656871dff7ed48592958d2453c541ddd3b3
<<<<<<< c5f6f3b787aedfa94cc5af106aa9649f38b5b85f
import MineralParsing.MineralDataI;
=======
import MineralParsing.interfaces.MineralDataI;
import MineralParsing.interfaces.ResolvedMineralDatumI;
>>>>>>> pushing
=======
import MineralParsing.MineralGridI;
>>>>>>> Refactors everything
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Converts MineralGrid to JSON strings.
 */
public class MineralDataToJson {
  public static String parseResolvedMineralData(MineralGridI mineralGridI) {
   return parseResolvedMineralDataToJson(mineralGridI).toString();
  }

  private static JSONArray parseResolvedMineralDataToJson(MineralGridI mineralData) {
    JSONArray outerArray = new JSONArray();
    for (List<ResolvedMineralDatumI> row : mineralData.getResolvedMineralRect()) {
      for (ResolvedMineralDatumI datum : row) {
<<<<<<< c5f6f3b787aedfa94cc5af106aa9649f38b5b85f
        outerArray.add(parseResolvedMineralDatumToJson(datum));
=======
        if (datum.getMinerals() != null) {
          outerArray.add(parseResolvedMineralDatumToJson(datum));
        }
>>>>>>> pushing
      }
    }

    return outerArray;
  }

  private static JSONObject parseResolvedMineralDatumToJson(ResolvedMineralDatumI mineralDatum) {
    JSONObject jsonDatum = new JSONObject();
    jsonDatum.put("r", mineralDatum.getRed());
    jsonDatum.put("g", mineralDatum.getGreen());
    jsonDatum.put("b", mineralDatum.getBlue());

    JSONObject jsonMinerals = new JSONObject();
    for (Map.Entry<String, Double> mineralEntry : mineralDatum.getMinerals().entrySet()) {
      jsonMinerals.put(mineralEntry.getKey(), mineralEntry.getValue());
    }
    jsonDatum.put("m", jsonMinerals);

    return jsonDatum;
  }
}
