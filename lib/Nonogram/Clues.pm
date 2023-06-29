package Nonogram::Clues;

use YAML::Tiny;

sub parse_clues_file {
    my ($filename) = @_;

    my $yaml = YAML::Tiny->read($filename);
    die "Failed to parse $filename: " . YAML::Tiny->errstr unless $yaml;

    my @row_clues    = map { [ split /,/, $_ ] } @{ $yaml->[0]->{row_clues} };
    my @column_clues = map { [ split /,/, $_ ] } @{ $yaml->[0]->{column_clues} };

    return ( \@row_clues, \@column_clues );
}

1;
