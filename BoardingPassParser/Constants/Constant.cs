using BoardingPassParser.Models;
using System.Collections.Generic;

namespace BoardingPassParser.Constants
{
    public static class Constant
    {
        private const int securityVar = -1;
        public const int MaxStandardIata = 158;

        public static List<BoardingPassFormat> BoardingPassFormats = new List<BoardingPassFormat>()
        {
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.FormatCode, Name ="FORMAT_CODE" , Length = 1, Offset =  1, Content =  "S|M", Explanation =  "Format Code"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.NumberOfSegments,Name ="NUMBER_OF_SEGMENTS" , Length = 1, Offset =  2, Content =  "[1-4]", Explanation =  "Number of Legs Encoded"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.PassengerName,Name ="PASSENGER_NAME" , Length = 20, Offset =  22, Content =  "", Explanation =  "Passenger Name"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.ElectronicTicketIndicator,Name ="ELECTRONIC_TICKET_INDICATOR" , Length = 1, Offset =  23, Content =  "E", Explanation =  "Electronic Ticket Indicator"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.OperatingCarrierPnrCode,Name ="OPERATING_CARRIER_PNR_CODE" , Length = 7, Offset =  30, Content =  "", Explanation =  "Operating Carrier PNR Code"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.FromCityAirportCode,Name ="FROM_CITY_AIRPORT_CODE" , Length = 3, Offset =  33, Content =  "", Explanation =  "From City Airport Code"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.ToCityAirportCode,Name ="TO_CITY_AIRPORT_CODE" , Length = 3, Offset =  36, Content =  "", Explanation =  "To City Airport Code"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.OperatingCarrierDesignator,Name ="OPERATING_CARRIER_DESIGNATOR" , Length = 3, Offset =  39, Content =  "", Explanation =  "Operating carrier Designator"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.FlightNumber,Name ="FLIGHT_NUMBER" , Length = 5, Offset =  44, Content =  "", Explanation =  "Flight Number"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.DateOfFlight,Name ="DATE_OF_FLIGHT" , Length = 3, Offset =  47, Content =  "[0-9]{3}", Explanation =  "Date of Flight (Julian Date)"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.CompartmentCode,Name ="COMPARTMENT_CODE" , Length = 1, Offset =  48, Content =  "[A-Z]", Explanation =  "Compartment Code"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.SeatNumber,Name ="SEAT_NUMBER" , Length = 4, Offset =  52, Content =  "", Explanation =  "Seat Number"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.CheckInSequenceNumber,Name ="CHECK_IN_SEQUENCE_NUMBER" , Length = 5, Offset =  57, Content =  "", Explanation =  "Check-in Sequence Number"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.PassengerStatus,Name ="PASSENGER_STATUS" , Length = 1, Offset =  58, Content =  "[0-9A-Z]", Explanation =  "Passenger Status"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.ConditionalsSize,Name ="CONDITIONALS_SIZE" , Length = 2, Offset =  60, Content =  "[0-F]{2}", Explanation =  "Field size of variable field (Conditional + Airline item 4)"},
	
	#region Conditional
	new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.BeginningOfVersionNumber,Name ="BEGINNING_OF_VERSION_NUMBER" , Length = 1, Offset =  61, Content =  "GREATER_THAN", Explanation =  "Beginning of version number"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.VersionNumber,Name ="VERSION_NUMBER" , Length = 1, Offset =  62, Content =  "[1-5]", Explanation =  "Version number"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.UniqueConditionalsSize,Name ="UNIQUE_CONDITIONALS_SIZE" , Length = 2, Offset =  64, Content =  "[0-F]{2}", Explanation =  "Field size of following structured message - unique"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.PassengerDescription,Name ="PASSENGER_DESCRIPTION" , Length = 1, Offset =  65, Content =  "[0-9A-Z\\s]", Explanation =  "Passenger Description"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.SourceOfCheckIn,Name ="SOURCE_OF_CHECK_IN" , Length = 1, Offset =  66, Content =  "[WKRMOTV\\s]", Explanation =  "Source of check-in"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.SourceOfBoardingPassIssuance,Name ="SOURCE_OF_BOARDING_PASS_ISSUANCE" , Length = 1, Offset =  67, Content =  "[WKXRMOTV\\s]", Explanation =  "Source of Boarding Pass Issuance"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.DateOfPassIssuance,Name ="DATE_OF_PASS_ISSUANCE" , Length = 4, Offset =  71, Content =  "[0-9]{4}", Explanation =  "Date of Issue of Boarding Pass (Julian Date)"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.DocumentType,Name ="DOCUMENT_TYPE" , Length = 1, Offset =  72, Content =  "B|I", Explanation =  "Document Type"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.AirlineDesignatorOfIssuer,Name ="AIRLINE_DESIGNATOR_OF_ISSUER" , Length = 3, Offset =  75, Content =  "", Explanation =  "Airline Designator of boarding pass issuer"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.BaggageTagLicensePlate,Name ="BAGGAGE_TAG_LICENSE_PLATE" , Length = 13, Offset =  88, Content =  "", Explanation =  "Baggage Tag License Plate Number (s)"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.FirstBaggageTagLicensePlate,Name ="FIRST_BAGGAGE_TAG_LICENSE_PLATE" , Length = 13, Offset =  101, Content =  "", Explanation =  "1st Non-Consecutive Baggage Tag License Plate Number"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.SecondBaggageTagLicensePlate,Name ="SECOND_BAGGAGE_TAG_LICENSE_PLATE" , Length = 13, Offset =  114, Content =  "", Explanation =  "2nd Non-Consecutive Baggage Tag License Plate Number"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.RepeatedConditionalsSize,Name ="REPEATED_CONDITIONALS_SIZE" , Length = 2, Offset =  116, Content =  "[0-F]{2}", Explanation =  "Field size of following structured message - repeated"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.AirlineNumericCode,Name ="AIRLINE_NUMERIC_CODE" , Length = 3, Offset =  119, Content =  "[0-9]{3}", Explanation =  "Airline Numeric Code"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.SerialNumber,Name ="SERIAL_NUMBER" , Length = 10, Offset =  129, Content =  "", Explanation =  "Document Form/Serial Number"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.SelecteeIndicator,Name ="SELECTEE_INDICATOR" , Length = 1, Offset =  130, Content =  "[\\s0-1]", Explanation =  "Selectee Indicator"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.InternationalDocumentVerification,Name ="INTERNATIONAL_DOCUMENT_VERIFICATION" , Length = 1, Offset =  131, Content =  "[\\s0-2]", Explanation =  "International Document Verification"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.MarketingCarrierDesignator,Name ="MARKETING_CARRIER_DESIGNATOR" , Length = 3, Offset =  134, Content =  "", Explanation =  "Marketing Carrier Designator"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.FrequentFlyerAirlineDesignator,Name ="FREQUENT_FLYER_AIRLINE_DESIGNATOR" , Length = 3, Offset =  137, Content =  "", Explanation =  "Frequent Flyer Airline Designator"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.FrequentFlyerNumber,Name ="FREQUENT_FLYER_NUMBER" , Length = 16, Offset =  153, Content =  "", Explanation =  "Frequent Flyer Number"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.IdAdIndicator,Name ="ID_AD_INDICATOR" , Length = 1, Offset =  154, Content =  "", Explanation =  "ID/AD Indicator"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.FreeBaggageAllowance,Name ="FREE_BAGGAGE_ALLOWANCE" , Length = 3, Offset =  157, Content =  "", Explanation =  "Free Baggage Allowance"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.FastTrack,Name ="FAST_TRACK" , Length = 1, Offset =  158, Content =  "[YN\\s]", Explanation =  "Fast Track"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.ForAirlineUse,Name ="FOR_AIRLINE_USE" , Length = securityVar, Offset =  158+securityVar, Content =  "", Explanation =  "For individual airline use"},

	#endregion

	#region Security
		new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.BeginningOfSecurityData,Name ="BEGINNING_OF_SECURITY_DATA" , Length = 1, Offset =  159+securityVar, Content =  "CARET_OR_GREATER_THAN", Explanation =  "Beginning of security data"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.TypeOfSecurityData,Name ="TYPE_OF_SECURITY_DATA" , Length = 1, Offset =  160+securityVar, Content =  "", Explanation =  "Type of Security Data"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.LengthOfSecurityData,Name = "LENGTH_OF_SECURITY_DATA" , Length = 2, Offset =  162+securityVar, Content =  "[0-F]{2}", Explanation =  "Length of Security Data"},
    new BoardingPassFormat {FieldType = Enums.IataBoardingPassFields.SecurityData,Name = "SECURITY_DATA" , Length = 100, Offset =  262+securityVar, Content =  "", Explanation =  "Security Data"} 
	#endregion

        };

    }
}
