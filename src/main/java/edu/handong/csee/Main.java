package edu.handong.csee;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class Main {
	
	String input;
	String output;
	boolean help=false;
	
	public static void main(String[] args)
	{
		Main main=new Main();
		main.run(args);
		Thread thread=new MergeExcelFile();
		thread.start();
	}
	
	public void run(String[] args)
	{
		Options options=createOption();
		
		if(parseOptions(options,args))
		{
			String[] arg= {input,output};
			
			if(help)
			{
				printHelp(options);
				return;
			}
			
			MergeExcelFile mergeExcelFile =new MergeExcelFile();
			mergeExcelFile.run(arg);
		}
	}
	
	private boolean parseOptions(Options options,String[] args)
	{
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);
			 
			input=cmd.getOptionValue("i");
			output=cmd.getOptionValue("o");
			help = cmd.hasOption("h");
		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}
	
	private Options createOption()
	{
		Options options=new Options();
		
		options.addOption(Option.builder("i").longOpt("input")
				           .desc("this is input path and reqired")
				           .hasArg()
				           .argName("input path")
				           .build());
		
		options.addOption(Option.builder("o").longOpt("output")
				          .desc("this is output path and required")
				          .hasArg()
				          .argName("out path")
				          .build());
		options.addOption(Option.builder("h").longOpt("help")
		                  .desc("help")
		                  .build());
		
		return options;
	}
	
	private void printHelp(Options options)
	{
		HelpFormatter formatter=new HelpFormatter();
		String header = "Java Final Project";
		String footer ="";
		formatter.printHelp("Java Final Project", header, options, footer, true);
	}
}
