package Nonogram::Clues;

use JSON qw(from_json);
use Path::Tiny;

sub parse_clues_file {
    my ($filename) = @_;

    # Read JSON from file
    my $json_data = path($filename)->slurp;

    # Parse JSON
    my $data = from_json($json_data);

    my @row_clues    = @{ $data->{row_clues} };
    my @column_clues = @{ $data->{column_clues} };

    return ( \@row_clues, \@column_clues );
}

1;
