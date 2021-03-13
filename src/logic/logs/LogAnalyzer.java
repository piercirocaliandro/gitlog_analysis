package logic.logs;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.LogCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

// this class analyze the git log, finding all the commit that contain a specific word 
//and reporting their ID's
public class LogAnalyzer {
	private String URI = "/home/pierciro/Scrivania/gitlog_analysis";
	public void analyzeLog() {
		try {
			Git repo = Git.open(new File(URI));
			LogCommand cmd = repo.log();
			
			try {
				Iterable<RevCommit> commits = cmd.call();
				for(RevCommit rev: commits) {
					if(rev.getShortMessage().contains("added")) {
						System.out.println(rev.getAuthorIdent() + "\n" + rev.getId() 
								+ "\n" + rev.getCommitTime() + "\n" + 
								rev.getShortMessage());
						System.out.println("\n");
					}
				}
			} catch (GitAPIException e) {
				Logger.getLogger("ANAL").log(Level.FINE, "GitAPIException\n");
			}
			
		} catch (IOException e) {
			Logger.getLogger("ANAL").log(Level.FINE, "Cannot open git repo\n");
			System.exit(-1);
		}
	}
}
