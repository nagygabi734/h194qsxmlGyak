<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Alkalmazott</h2>
				<table border="2">
					<tr bgcolor="green">
						<th>ID</th>
						<th>Keresztnev</th>
						<th>Vezeteknev</th>
						<th>Becenev</th>
						<th>Fizetes</th>
					</tr>
					<xsl:for-each select="osztaly/alkalmazott">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td>
								<xsl:value-of select="keresztnev"/>
							</td>
							<td>
								<xsl:value-of select="vezeteknev"/>
							</td>
							<td>
								<xsl:value-of select="becenev"/>
							</td>
							<td>
								<xsl:value-of select="fizetes"/>
							</td>
						</tr>
					</xsl:for-each>
				</table>
				<p1>ID</p1>
				<p1>Keresztnev</p1>
				<p1>Vezetéknév</p1>
				<p1>Becenév</p1>
				<p1>Fizetés</p1>

				<xsl:for-each select="osztaly/alkalmazott">
					<br></br>
					<xsl:value-of select="@id" />
					<xsl:value-of select="keresztnev"/>
					<xsl:value-of select="vezeteknev"/>
					<xsl:value-of select="becenev"/>
					<xsl:value-of select="fizetes"/>


				</xsl:for-each>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>