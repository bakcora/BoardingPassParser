using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace BoardingPassParser.Test
{
    [TestClass]
    public class BoardingPassTest
    {
        private string[] inputs = new string[] {

            "M1SERGEEV.MAKSIM       NPCB8H SAWVKODP 0884 079Y031A0163 147Ç1181OO9079BDP 0000000000000294250652645443 0"};

        [TestMethod]
        public void BoardingPassParse()
        {
            var list = string.Empty;

            foreach (var input in inputs)
            {
                var passenger = BoardingPassHelper.Parse(input);
                // var str = Newtonsoft.Json.JsonConvert.SerializeObject(passenger,Newtonsoft.Json.Formatting.Indented);
                if (passenger != null)
                    list += Environment.NewLine + passenger.ToString();
            }

        }
    }
}
