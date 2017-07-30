import java.util.Properties;

public class ExecuteLocalOozieScheduler {
		
	
	public static void main(String[] args) throws Exception {
		
		LocalOozie.start();
		
		 // get a OozieClient for local Oozie	
	    OozieClient wc = LocalOozie.getClient();

	    Properties conf = wc.createConfiguration();

	    conf.setProperty(OozieClient.APP_PATH, 
	    "hdfs://kingsolomon:9000/user/hadoopadmin/Desktop/ExecuteOozieJobUsingJavaAPI/workflow.xml");
	    conf.setProperty("jobTracker", "kingsolomon:9001");
	    conf.setProperty("nameNode", "hdfs://kingsolomon:9000");
	    conf.setProperty("queueName", "default");
	    conf.setProperty("dbScripts", "/user/hadoopadmin/Desktop/ExecuteOozieJobUsingJavaAPI");
	    conf.setProperty("rootFolder", "/user/hadoopadmin/Desktop/ExecuteOozieJobUsingJavaAPI");
	    // HDFS directories (multiple directories can be separated by a comma) that contain JARs
	    conf.setProperty("oozie.libpath", "hdfs://kingsolomon:9000/user/oozie/share/lib");
	    conf.setProperty("oozie.use.system.libpath", "true");
	    conf.setProperty("oozie.wf.rerun.failnodes", "true");

	    try {
	        String jobId = wc.run(conf);
	        System.out.println("Workflow job, " + jobId + " submitted");

	        while (wc.getJobInfo(jobId).getStatus() == WorkflowJob.Status.RUNNING) {
	            System.out.println("Workflow job running ...");
	            Thread.sleep(10 * 1000);
	        }
	        System.out.println("Workflow job completed ...");
	        System.out.println(wc.getJobInfo(jobId));
	    } catch (Exception r) {
	        System.out.println("Errors " + r.getLocalizedMessage());
	    }
	}

}
