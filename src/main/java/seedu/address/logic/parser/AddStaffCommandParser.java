package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddStaffCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.StaffContact;
import seedu.address.model.person.StaffDepartment;
import seedu.address.model.person.StaffInsurance;
import seedu.address.model.person.StaffName;
import seedu.address.model.person.StaffTitle;

/**
 * Parses input arguments and creates a new AddStaffCommand object
 */
public class AddStaffCommandParser implements Parser<AddStaffCommand>{

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddStaffCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_STAFF_CONTACT, PREFIX_STAFF_NAME, PREFIX_STAFF_DEPARTMENT,
                        PREFIX_STAFF_INSURANCE, PREFIX_STAFF_TITLE);

        if (!arePrefixesPresent(argMultimap, PREFIX_STAFF_CONTACT, PREFIX_STAFF_NAME, PREFIX_STAFF_DEPARTMENT,
                PREFIX_STAFF_INSURANCE, PREFIX_STAFF_TITLE) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        StaffContact staffContact = ParserUtil.parseStaffContact(argMultimap.getValue(PREFIX_STAFF_CONTACT).get());
        StaffDepartment staffDepartment =
                ParserUtil.parseStaffDepartment(argMultimap.getValue(PREFIX_STAFF_DEPARTMENT).get();
        StaffInsurance staffInsurance =
                ParserUtil.parseStaffInsurance(argMultimap.getValue(PREFIX_STAFF_INSURANCE).get());
        StaffName staffName =
                ParserUtil.parseStaffName(argMultimap.getValue(PREFIX_STAFF_NAME).get());
        StaffTitle staffTitle =
                ParserUtil.parseStaffTitle(argMultimap.getValue(PREFIX_STAFF_TITLE).get());


        // do staff creation
        // do project name parsing
        // return new add staff command
    }



    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }


}
