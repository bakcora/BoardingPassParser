using BoardingPassParser.Enums;

namespace BoardingPassParser.Models
{
    public class BoardingPassFormat
    {
        public IataBoardingPassFields FieldType { get; set; }
        public string Name { get; set; }
        public int Length { get; set; }
        public int Offset { get; set; }
        public string Content { get; set; }
        public string Explanation { get; set; }
    }
}
