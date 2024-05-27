package bigdata;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.FloatWritable;

public class MapperYT extends Mapper<LongWritable, Text, Text, FloatWritable> {

    private final static FloatWritable views = new FloatWritable();
    private Text category = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String[] columns = value.toString().split(",");

        if (columns.length >= 7) {
            String categoryStr = columns[3].trim();
            try {
                float viewsCount = Float.parseFloat(columns[5].trim());
                category.set(categoryStr);
                views.set(viewsCount);
                context.write(category, views);
            } catch (NumberFormatException e) {
                // Skip invalid views count
            }
        }
    }
}
