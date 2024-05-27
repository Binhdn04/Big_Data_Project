package bigdata;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerYT extends Reducer<Text, FloatWritable, Text, FloatWritable> {

    private TreeMap<Float, String> categoryViewsMap = new TreeMap<>();

    @Override
    public void reduce(Text key, Iterable<FloatWritable> values, Context context)
            throws IOException, InterruptedException {

        float viewsCount = 0;
        for (FloatWritable val : values) {
            viewsCount += val.get();
        }
        categoryViewsMap.put(viewsCount, key.toString());

        // Keep only top 10 categories
        if (categoryViewsMap.size() > 10) {
            categoryViewsMap.remove(categoryViewsMap.firstKey());
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        for (Map.Entry<Float, String> entry : categoryViewsMap.descendingMap().entrySet()) {
            context.write(new Text(entry.getValue()), new FloatWritable(entry.getKey()));
        }
    }
}
