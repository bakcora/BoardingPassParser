using BoardingPassParser.Constants;
using BoardingPassParser.Extension;
using System.Linq;
using System.Text;

namespace BoardingPassParser.Models
{
    [System.Serializable]
    public class PassengerInfo
    {
        public string FormatCode { get; set; }
        public string NumberOfSegments { get; set; }
        public string PassengerName { get; set; }
        public string ElectronicTicketIndicator { get; set; }
        public string OperatingCarrierPnrCode { get; set; }
        public string FromCityAirportCode { get; set; }
        public string ToCityAirportCode { get; set; }
        public string OperatingCarrierDesignator { get; set; }
        public string FlightNumber { get; set; }
        public string DateOfFlight { get; set; }
        public string CompartmentCode { get; set; }
        public string SeatNumber { get; set; }
        public string CheckInSequenceNumber { get; set; }
        public string PassengerStatus { get; set; }
        public string ConditionalsSize { get; set; }
        
        #region conditional
        public string BeginningOfVersionNumber { get; set; }
        public string VersionNumber { get; set; }
        public string UniqueConditionalsSize { get; set; }
        public string PassengerDescription { get; set; }
        public string SourceOfCheckIn { get; set; }
        public string SourceOfBoardingPassIssuance { get; set; }
        public string DateOfPassIssuance { get; set; }
        public string DocumentType { get; set; }
        public string AirlineDesignatorOfIssuer { get; set; }
        public string BaggageTagLicensePlate { get; set; }
        public string FirstBaggageTagLicensePlate { get; set; }
        public string SecondBaggageTagLicensePlate { get; set; }
        public string RepeatedConditionalsSize { get; set; }
        public string AirlineNumericCode { get; set; }
        public string SerialNumber { get; set; }
        public string SelecteeIndicator { get; set; }
        public string InternationalDocumentVerification { get; set; }
        public string MarketingCarrierDesignator { get; set; }
        public string FrequentFlyerAirlineDesignator { get; set; }
        public string FrequentFlyerNumber { get; set; }
        public string IdAdIndicator { get; set; }
        public string FreeBaggageAllowance { get; set; }
        public string FastTrack { get; set; }
        public string ForAirlineUse { get; set; } 
        #endregion
        #region security
        public string BeginningOfSecurityData { get; set; }
        public string TypeOfSecurityData { get; set; }
        public string LengthOfSecurityData { get; set; }
        public string SecurityData { get; set; }
        #endregion

        public override string ToString()
        {
            var formats = Constant.BoardingPassFormats.OrderBy(d => d.Offset).ToList();

            var sb = new StringBuilder();

            var fields = GetType().GetFields(System.Reflection.BindingFlags.Instance | System.Reflection.BindingFlags.Static | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Public);

            foreach (var f in formats)
            {
                var field = fields.FirstOrDefault(d => d?.Name.Replace("<", string.Empty).Replace(">k__BackingField", string.Empty) == f.FieldType.ToString());

                if (field == null)
                {
                    sb.Append(string.Empty.AddSpace(f.Length));
                }
                else
                {
                    sb.Append((field.GetValue(this) == null ? string.Empty : field.GetValue(this).ToString()).AddSpace(f.Length));
                }
            }

            return sb.ToString();
        }
    }
}
