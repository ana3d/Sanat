#!/usr/bin/perl -w

# crontab, copy this to root/bin/
# 0 16 * * * /root/bin/send_email_notification.pl >/dev/null 2>&1


use Mail::Sendmail;
use strict;
use warnings;
use DBI;
use Data::Dumper;
use POSIX qw(strftime);
use LWP::Simple;

#variables
my $driver = "mysql";
my $database = "TÄHÄN TIETOKANTA";
my $dsn = "DBI:$driver:database=$database";
my $userid = "TIETOKANNAN KÄYTTÄJÄTUNNUS";
my $password = "TIETOKANNAN SALASANA";
my $dbh = DBI->connect($dsn, $userid, $password ) or die $DBI::errstr;
my $currentDate = strftime( '%Y-%m-%d', localtime );
my $dateFromDB = '';

#sql stuff
my $sql = qq/SELECT id, aika FROM sanat ORDER BY id DESC LIMIT 1/;      # the query to execute
my $sth = $dbh->prepare($sql);                                          # prepare the query
$sth->execute();                                                        # execute the query
my @row;
my ($id, $timestamp);
$sth->bind_col(1, \$id);
$sth->bind_col(2, \$timestamp);

while (@row = $sth->fetchrow_array) {  # retrieve one row
}

# substring to get proper format of dates
$dateFromDB = substr $timestamp, 0, 10;
$currentDate = substr $currentDate, 0, 10;


my $to = 'to@mail';
my $from = 'from@mail';
my $subject = 'Uusia sanoja!';
my $message = 'Sovellukseen tullut uusia sanoja.';
 



if ($currentDate eq $dateFromDB) {

	open(MAIL, "|/usr/sbin/sendmail -t");

	# Email Header
	print MAIL "To: $to\n";
	print MAIL "From: $from\n";
	print MAIL "Subject: $subject\n\n";
	# Email Body
	print MAIL $message;

	close(MAIL);
	print "Email Sent Successfully\n";
}
