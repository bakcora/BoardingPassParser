using BoardingPassParser.Constants;
using BoardingPassParser.Models;
using System;
using System.Linq;

namespace BoardingPassParser
{
    public static class BoardingPassHelper
    {
        private static string Input { get; set; }
        public static PassengerInfo Parse(string input)
        {
            Input = input.ToUpper().Replace(".","/");
            var passengerInfo = new PassengerInfo();
            try
            {
                var fields = passengerInfo.GetType().GetFields(System.Reflection.BindingFlags.Instance | System.Reflection.BindingFlags.Static | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Public);
                foreach (var format in Constant.BoardingPassFormats)
                {
                    try
                    {
                        var field = fields.FirstOrDefault(d => d?.Name.Replace("<", string.Empty).Replace(">k__BackingField", string.Empty) == format.FieldType.ToString());
                        if (field == null)
                            continue;
                        var value = GetBoardingPassField(format, Input);
                        if (!string.IsNullOrWhiteSpace(value))
                        {
                            field.SetValue(passengerInfo, value);
                        }
                    }
                    catch (Exception)
                    {
                        continue;
                    }
                }
                return passengerInfo;
            }
            catch (Exception ex)
            {
                return passengerInfo;
            }
        }

        private static string GetBoardingPassField(BoardingPassFormat format, string input)
        {
            if (format.Offset <= Input.Length && Input.Length <= Constant.MaxStandardIata)
            {
                var tmp = Input.Substring(format.Offset - format.Length, format.Length);
                return tmp.Trim().Length == 0 ? null : tmp.Trim();
            }
            return null;
        }
    }
}
