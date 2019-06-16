package eud.handong.csee;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class Main {
	
	String input;
	String output;
	boolean help;
	
	public static void main(String[] args)
	{
		Main main=new Main();
		main.run(args);
	}
	
	public void run(String[] args)
	{
		Options options=createOption();
		
		if(parseOptions(options,args))
		{
			
		}
	}
	
	private boolean parseOptions(Options options,String[] args)
	{
		
	}
	
	private Options createOprions()
	{
		Options options=new Options();
		
		options.addOption((Option.builder("i").longOpt("input")
				           .desc("this is input name and reqired")
				           .hasArg()
				           .argname("input path")
				           .required()
				           .build());
	}
	
	private void printHelp(Options options)
	{
		HelpFormatter formatter=new HelpFormatter();
		String header = "Java Final Project";
		String footer ="";
		formatter.printHelp("Java Final Project", header, options, footer, true);
	}
}
