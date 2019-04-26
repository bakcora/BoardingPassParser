using System.Text;

namespace BoardingPassParser.Extension
{
    public static class StringExtension
    {
        public static string AddSpace(this string value, int totalLength)
        {
            var sb = new StringBuilder();
            if (string.IsNullOrEmpty(value))
            {
                for (var i = 0; i < totalLength; i++)
                    sb.Append(" ");

                return sb.ToString();
            }
            
            if (value.Length > totalLength)
                return value.Substring(0, totalLength);

            sb.Append(value);
            for (var i = 0; i < (totalLength - value.Length); i++)
            {
                sb.Append(" ");
            }

            return sb.ToString();
        }
    }
}
